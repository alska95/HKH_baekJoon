package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];
        Long[][]dp = new Long[n][21];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 21 ; j ++){
                dp[i][j] = 0L;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][numList[0]] = 1L;

        for(int i = 1 ; i< n ; i++){
            for(int j = 0 ; j <= 20 ; j++){
                if(dp[i-1][j]!=0L){
                    int _target1 = j + numList[i];
                    int _target2 = j - numList[i];
                    if(_target1 < 21 && _target1 >= 0)
                        dp[i][_target1]+=dp[i-1][j];
                    if(_target2 < 21 && _target2 >= 0)
                        dp[i][_target2]+=dp[i-1][j];
                }
            }
        }
        bw.write(""+dp[n-2][numList[n-1]]);
        bw.close();
    }
}
