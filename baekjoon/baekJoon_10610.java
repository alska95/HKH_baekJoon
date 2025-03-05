package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] n = br.readLine().toCharArray();
        int sum = 0;
        int flag = 0;
        for(int i = 0 ; i < n.length ; i++){
            int target = Integer.parseInt(String.valueOf(n[i]));
            sum += target;
            if(target == 0){
                flag = 1;
            }
        }
        if(sum%3 != 0 || flag == 0){
            bw.write("-1\n");
        }else{
            Arrays.sort(n);
            for(int i = n.length-1 ; i>= 0 ;i--)
                bw.write(n[i]);
            bw.write("\n");
        }
        bw.close();
    }
}
