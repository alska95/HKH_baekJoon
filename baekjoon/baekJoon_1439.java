package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int zeroSum = 0;
        int oneSum = 0;
        if(target.charAt(0) == '0')
            zeroSum++;
        else
            oneSum++;
        for(int i = 1 ; i < target.length() ; i++){
            if(target.charAt(i) == '0'){
                if(target.charAt(i-1) == '0')
                    continue;
                else
                    zeroSum++;
            }else{
                if(target.charAt(i-1) == '1')
                    continue;
                else
                    oneSum++;
            }
        }
        bw.write(Math.min(zeroSum , oneSum)+"");
        bw.close();
    }
}
