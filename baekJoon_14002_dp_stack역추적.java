import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int board[] = new int[n];
        int dp[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 0;
        for(int i = 0 ; i < n  ; i++){
            for(int j = 0 ; j < i ; j++){
                if(board[i] > board[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }

        Stack<Integer> traceStack = new Stack<>();
        int targetVal = max;
        for(int i = n-1 ; i >= 0 ; i--){
            if(dp[i] == targetVal){
                traceStack.add(board[i]);
                targetVal--;
            }
            if(targetVal == 0)
                break;
        }


        bw.write(max + "\n");
        StringBuilder sb =new StringBuilder();
        while(!traceStack.isEmpty()){
            sb.append(traceStack.pop()).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}