package baekjoon;

import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp = Integer.parseInt(st.nextToken());
        int flag = 0;
        if( tmp== 1){
            for(int i = 2 ; i < 9 ; i++){
                if(Integer.parseInt(st.nextToken()) != i){
                    break;
                }
                if(i == 8)
                    flag =1;
            }
        }else if(tmp == 8){
            for(int i = 7 ; i > 0 ; i--){
                if(Integer.parseInt(st.nextToken()) != i){
                    flag = 1;
                    break;
                }
                if(i == 1)
                    flag =2;
            }
        }
        if(flag == 0)
            bw.write("mixed");
        else if(flag ==1)
            bw.write("ascending");
        else if(flag == 2)
            bw.write("descending");
        bw.close();
    }
}
