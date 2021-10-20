import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] board = Arrays.stream(br.readLine().split(" "))
                .mapToInt(v -> Integer.parseInt(v)).toArray();
        int[] dp = new int[Arrays.stream(board).sum()+1];
        for(int i = 1 ; i <= board[0] ; i++){
            for(int j = 1 ; j <= board[1] ; j++){
                for(int k = 1 ; k <= board[2] ; k++){
                    dp[i+j+k]++;
                }
            }
        }
        int maxIter = 0;
        int max = 0;
        for(int i = 0 ; i < dp.length ; i++){
            if(dp[i] > max){
                max = dp[i];
                maxIter = i;
            }
        }
        bw.write(maxIter+"");
        bw.close();
    }
}