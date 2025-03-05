package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int board[] = new int[n];
        int cache[] = new int[n];
        int dp[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 0;
        int maxIter = 0;
        for(int i = 0 ; i < n  ; i++){
            for(int j = 0 ; j < i ; j++){
                if(board[i] > board[j]){
                    if(dp[i] < dp[j]+1){
                        cache[i] = j;
                        dp[i] = dp[j]+1;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                maxIter = i;
            }
        }
        ArrayList<Integer> resultArray = new ArrayList<>();
        int index = maxIter;
        resultArray.add(board[maxIter]);
        for(int i = 0 ; i < max-1 ; i++){
            resultArray.add(board[cache[index]]);
            index = cache[index];
        }
        bw.write(max + "\n");
        for(int i = resultArray.size()-1 ; i >=0 ; i--){
            bw.write(resultArray.get(i)+" ");
        }
        bw.close();
    }
}
