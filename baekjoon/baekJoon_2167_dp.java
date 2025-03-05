package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int board[][]= new int[n+1][m+1];
        int dp[][]= new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            for(int j = 1 ; j <= m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                dp[i][j] = board[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        int testCase = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < testCase ; z++){
            st = new StringTokenizer(br.readLine() , " ");
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int result = dp[ry][rx]+dp[ly-1][lx-1]-dp[ly-1][rx]-dp[ry][lx-1];
            bw.write(result+"\n");
        }
        bw.close();
    }
}
