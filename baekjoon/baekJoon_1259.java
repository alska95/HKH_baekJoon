package baekjoon;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        while(!target.equals("0")){
            int length = target.length();
            int flag = 0;
            for(int i = 0 ; i < length ; i++){
                if(target.charAt(i) != target.charAt(length-i-1)){
                    bw.write("no\n");
                    flag =1;
                    break;
                }
            }
            if(flag == 0)
                bw.write("yes\n");
            target = br.readLine();
        }
        bw.close();
    }
}
