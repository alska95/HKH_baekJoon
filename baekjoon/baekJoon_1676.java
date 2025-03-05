package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int two = 0;
        int five = 0;
        for(int i = 2 ; i <= n ; i*=2)
            two+=n/i;
        for(int i = 5 ; i <= n ; i*=5)
            five+=n/i;
        bw.write(Math.min(two,five)+"");
        bw.close();
    }
}
