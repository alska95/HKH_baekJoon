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

        int [][] dp = new int [n+1][n+1];
        for(int i = 1 ; i < n+1 ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            for(int j = 1 ; j < n+1 ; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(i == 1){
                    if(j > 1){
                        dp[i][j] = dp[i][j-1]+tmp;
                    }else{
                        dp[i][j] = tmp;
                    }
                }else if(j ==1){
                    dp[i][j] = dp[i-1][j]+tmp;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+tmp;
                }
            }
        }

        for(int z = 0 ; z < m ; z++){
            st = new StringTokenizer(br.readLine() , " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int result = dp[y2][x2]-(dp[y2][x1-1]+dp[y1-1][x2]-dp[y1-1][x1-1]);
            bw.write(result + "\n");
        }
        bw.close();
    }
}

/*
 * 위더하기 옆 마이너스 대각선*/
