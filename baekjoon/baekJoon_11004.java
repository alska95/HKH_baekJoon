package baekjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int board [] = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st= new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0 ; i < k-1 ; i++){
            pq.poll();
        }
        bw.write(pq.peek()+"");
        bw.close();
    }
}
