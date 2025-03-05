package baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger ans = new BigInteger("1");

        for(int i = n ; i > n-m ; i--){
            ans = ans.multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(n-i+1));
        }
        bw.write(ans+"");
        bw.close();
    }
}
