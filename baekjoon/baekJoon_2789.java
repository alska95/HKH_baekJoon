package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        String filter = "CAMBRIDGE";
        for(int i = 0 ; i< filter.length() ; i++){
            target = target.replaceAll(String.valueOf(filter.charAt(i)), "");
        }
        bw.write(target);
        bw.close();
    }
}
