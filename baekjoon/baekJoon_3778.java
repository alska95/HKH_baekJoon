package baekjoon;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int z = 1 ; z<= t ; z++){
            int [] boardA = new int[123];
            int [] boardB = new int[123];
            String a = br.readLine();
            String b = br.readLine();

            for(int i = 0 ; i < a.length() ; i++){
                boardA[a.charAt(i)] += 1;
            }

            for(int i = 0 ; i < b.length() ; i++){
                boardB[b.charAt(i)] += 1;
            }

            int result = 0;

            for(int i = 97 ; i < 123 ; i++){
                result += Math.abs(boardA[i] - boardB[i]);
            }
            sb.append("Case #").append(z).append(": ").append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
