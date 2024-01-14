import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            int target = (int) Math.sqrt(i);
            int sum = 0;
            for(int j = 1 ; j <= target ; j++){
                if(i%j == 0){
                    sum++;
                }
            }
            dp[i] = dp[i-1] + sum;
        }
        bw.write(dp[n]+"");
        bw.close();
    }
}
