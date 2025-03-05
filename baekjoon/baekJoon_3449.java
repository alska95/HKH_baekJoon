package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            String a = br.readLine();
            String b = br.readLine();
            int result = 0;
            for(int j = 0 ; j < a.length() ; j++){
                if(a.charAt(j) != b.charAt(j))
                    result++;
            }
            sb.append("Hamming distance is ").append(result).append(".\n");
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        bw.close();
    }
}
