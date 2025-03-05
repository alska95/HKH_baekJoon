package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < testCase ; z++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            ArrayList<ArrayList<Integer>> board = new ArrayList<>();
            for(int i = 0 ; i <= n ; i++){
                board.add(new ArrayList<>());
            }
            for(int i = 1 ; i <= n ; i++){
                board.get(i).add(Integer.parseInt(st.nextToken()));
            }
            int visited [] = new int[n+1];
            int count = 0;
            for(int i = 1 ; i <= n ;i++){
                if(visited[i] == 0){
//                    System.out.println("i = " + i);
                    count++;
                    Queue<Integer> bfsQueue = new LinkedList<>();
                    visited[i] = 1;
                    int tmp = board.get(i).get(0);
                    bfsQueue.add(tmp);
                    visited[tmp] = 1;
                    while(!bfsQueue.isEmpty()){
                        int next = board.get(bfsQueue.poll()).get(0);
                        if(visited[next] == 0){
                            bfsQueue.add(next);
                            visited[next]=1;
                        }
                    }
                }
            }
            bw.write(count+"\n");

        }
        bw.close();
    }
}
