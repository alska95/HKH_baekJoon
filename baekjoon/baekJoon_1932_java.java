package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int[n+1][n+1];
        for(int i = 1 ; i < n+1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0  ; j < i ; j++){
                int next = Integer.parseInt(st.nextToken());
                if(j < 1){
                    dp[i][j] = next+dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(next+dp[i-1][j-1] , next+dp[i-1][j]);
                }
            }
        }
        bw.write(Arrays.stream(dp[n]).max().getAsInt() + "");
        bw.close();
    }
}
