package baekjoon;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int board[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }
        long result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result += Math.abs(board[i]-board[j]);
            }
        }
        bw.write(result+"");
        bw.close();
    }
}
