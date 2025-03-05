package baekjoon;

import java.io.*;
import java.util.*;

class Node{
    int target;
    int cost;

    public Node(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int [] visited = new int[n+1];
        ArrayList<ArrayList<com.company.Node>> board = new ArrayList<>();
        PriorityQueue<com.company.Node> pqPrim = new PriorityQueue<>(new Comparator<com.company.Node>() {
            @Override
            public int compare(com.company.Node o1, com.company.Node o2) {
                return o1.cost - o2.cost;
            }
        });
        for(int i = 0 ; i < n+1 ; i++){
            board.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            board.get(start).add(new com.company.Node(target , cost));
            board.get(target).add(new com.company.Node(start ,cost));
        }

        for(int i = 0 ; i < board.get(1).size() ; i++){
            pqPrim.add(board.get(1).get(i));
        }

        while(!pqPrim.isEmpty()){
            com.company.Node next = pqPrim.poll();
            int cost = next.cost;
            int target = next.target;
            if(visited[target] == 0 && target != 1){
                visited[target] = cost;
                for(int i = 0 ; i < board.get(target).size() ; i++){
                    pqPrim.add(board.get(target).get(i));
                }
            }
        }

        bw.write(Arrays.stream(visited).sum()+"");
        bw.close();
    }
}
