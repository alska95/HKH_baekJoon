package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n*2 ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i%2==0 && j%2==0){
                    bw.write("*");
                }else if(i%2 ==1 && j%2==1){
                    bw.write("*");
                }else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}
