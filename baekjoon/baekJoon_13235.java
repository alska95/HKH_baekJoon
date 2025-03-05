package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int middle = (int) Math.ceil(target.length()/2);
        boolean flag = true;
        for(int i = 0 ; i < middle ; i++){
            char a = target.charAt(i);
            char b = target.charAt(target.length()-1-i);
            if(a != b){
                flag = false;
                break;
            }
        }
        bw.write(flag+"");
        bw.close();
    }
}
