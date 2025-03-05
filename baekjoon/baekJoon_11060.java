package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        int board[] = new int[target];
        int dp[] = new int[target];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < target ; i++){
            board[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 0 ; i < target ; i++){
            int iter = board[i];
            if(dp[i] != Integer.MAX_VALUE){
                for(int j = 1 ; j <= iter ; j++){
                    int jump = i+j;
                    if(jump >= target)
                        break;
                    dp[jump] = Math.min(dp[i]+1, dp[jump]);
                }
            }
        }
        if(dp[target-1] == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(dp[target-1]+"");

        bw.close();
    }
}
