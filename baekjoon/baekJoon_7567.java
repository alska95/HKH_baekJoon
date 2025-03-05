package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int result = 0;
        for (int i = 0; i < target.length(); i++) {
            if (i != 0 && target.charAt(i - 1) == target.charAt(i)) {
                result += 5;
            } else {
                result += 10;
            }
        }
        bw.write(result+"");
        bw.close();
    }
}
