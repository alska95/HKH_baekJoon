import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        BigInteger dp[] = new BigInteger[70];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        dp[3] = BigInteger.valueOf(4);
        for(int i = 4 ; i < 70 ;i++){
            dp[i] = dp[i-3].add(dp[i-2]).add(dp[i-1]).add(dp[i-4]);
        }
        for(int z = 0 ; z < testCase ; z++){
            bw.write(dp[Integer.parseInt(br.readLine())].toString()+"\n");
        }
        bw.close();
    }
}