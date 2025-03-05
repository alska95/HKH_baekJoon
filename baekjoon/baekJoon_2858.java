package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum= R+B;
        int resultW = 0;
        int resultL = 0;
        for(int i = 1 ; i < sum/2 ; i++) {
            if(sum % i != 0)
                continue;
            int W = i;
            int L = sum/i;
            int targetR = 2* (W + L - 2);
            if(R == targetR){
                resultW = W;
                resultL = L;
            }
        }
        bw.write(resultW + " " + resultL);
        bw.close();
    }
}
