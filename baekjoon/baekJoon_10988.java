package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int flag = 1;
        for(int i = 0 ; i < target.length()/2+1 ; i++){
            if(target.charAt(i) != target.charAt(target.length()-1-i)){
                flag = 0;
                break;
            }
        }
        bw.write(flag + "");
        bw.close();
    }
}
