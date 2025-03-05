package baekjoon;

import java.io.*;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1[] = br.readLine().split( " ");
        int N = Integer.parseInt(str1[0]);
        int K = Integer.parseInt(str1[1]);
        int F = Integer.parseInt(str1[2]);
        int R = Math.max(N * K - F, 0);
        bw.write(String.valueOf(R));
        bw.flush();
    }
}
