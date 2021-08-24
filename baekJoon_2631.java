import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int child[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i  = 0 ; i < n ; i++){
            child[i] = Integer.parseInt(br.readLine());
        }
        int max =0;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0; j< i ; j++){
                if(child[j] < child[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = max < dp[i] ? dp[i] : max;
        }

        bw.write(n-max+"");
        bw.close();
    }
}
