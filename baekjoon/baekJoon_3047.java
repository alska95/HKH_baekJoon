package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < 3 ; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        Map<Character, Integer> board = new HashMap<>();
        board.put('A', pq.poll());
        board.put('B', pq.poll());
        board.put('C', pq.poll());
        String target = br.readLine();
        for(int i = 0 ; i < 3 ; i++){
            bw.write(board.get(target.charAt(i))+" ");
        }
        bw.close();
    }
}
