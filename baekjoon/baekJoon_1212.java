package baekjoon;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] binary= {"000","001","010","011","100","101","110","111"};

        String target=br.readLine();

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int cur=target.charAt(i)-'0';
            if(i==0 && cur<4) {
                if(cur<2) {
                    sb.append(binary[cur].substring(2));
                }else {
                    sb.append(binary[cur].substring(1));
                }

            }else {
                sb.append(binary[cur]);
            }

        }
        bw.write(sb.toString());
        bw.close();

    }
}
