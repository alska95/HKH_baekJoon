package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i ++){
            int target = Integer.parseInt(br.readLine());
            int count = 1;
            while(true){
                if(count + Math.pow(count, 2) <= target){
                    count++;
                }else{
                    break;
                }
            }
            bw.write(count-1 + "\n");
        }
        bw.close();
    }
}
