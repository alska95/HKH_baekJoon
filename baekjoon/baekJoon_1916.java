package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> board = new ArrayList<>(); //target , cost
        for(int i = 0 ; i < n+1 ; i++){
            board.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start =Integer.parseInt(st.nextToken());
            int target =Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            board.get(start).add(new int[]{target, cost});
//            board.get(target).add(new int[]{start, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<int []> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int [] visited = new int[1001];
        for(int i = 0 ; i < board.get(start).size();i++){
            int nextTarget = board.get(start).get(i)[0];
            int nextCost = board.get(start).get(i)[1];
            pQueue.add(new int[]{nextTarget, nextCost});
        }
        visited[start] = 1;
        int result = 0;
        while(!pQueue.isEmpty()){
            int []next = pQueue.poll();
            int target = next[0];
            int cost = next[1];
//            System.out.println("cost = " + cost);
            if(visited[target] == 0){
                visited[target] = 1;
                if(target == end){
//                    System.out.println("yes");
                    result = cost;
                    break;
                }
                for(int i = 0 ; i < board.get(target).size() ; i++){
                    int nextTarget = board.get(target).get(i)[0];
                    int nextCost = board.get(target).get(i)[1]+cost;
//                    System.out.println("nextCost = " + board.get(target).get(i)[1] + "nextTarget = " + nextTarget);
//                    System.out.println();
                    pQueue.add(new int[]{nextTarget, nextCost});
                }
            }
        }
        bw.write(result+"");
        bw.close();

    }
}
