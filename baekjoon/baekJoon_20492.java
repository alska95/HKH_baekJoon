package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        bw.write((target / 100)*78 + " " + (target -((((target / 100)*20)/100)*22) ));
        bw.close();
    }
}
