package baekjoon;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int volumeList[] = new int [n+1];


        int dp[][]= new int[n+1][max+1];
        st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i< n ; i++){
            volumeList[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][start] = 1;
        for(int i = 1; i <= n ; i++){
            for(int j = 0 ; j <= max ; j++){
                if(dp[i-1][j] == 1){
                    if(j-volumeList[i-1] >=0){
                        dp[i][j-volumeList[i-1]] = 1;
                    }
                    if(j+volumeList[i-1] <= max)
                        dp[i][j+volumeList[i-1]] = 1;
                }
            }
        }
        int result = -1;
        for(int i = max ; i >=0 ; i--){
            if(dp[n][i] ==1){
                result = i;
                break;
            }
        }
        bw.write(result+"");
        bw.close();
    }
}
