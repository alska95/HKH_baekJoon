package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < 9 ; i++){
            result+=Integer.parseInt(br.readLine());
        }
        bw.write(sum-result+"");
        bw.close();
    }
}
