package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb =new StringBuilder();

        int n = -1;
        int count = 1;
        while(n != 0){
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            sb.append("\nGroup "+count+"\n");
            count++;

            String names[] = new String[n];
            String status[][] = new String[n][n];
            boolean flag = false;
            for(int i = 0 ; i < n ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine() , " ");
                for(int j = 0 ; j < n ; j++){
                    if(j == 0){
                        names[i] = st.nextToken();
                    }else{
                        status[i][j] = st.nextToken();
                    }
                }
            }
            for(int i = 0 ; i < n ; i ++ ){
                for(int j = 1 ; j < n ; j++){
                    if(status[i][j].equals("N")){
                        int target = 0;
                        flag = true;
                        if(i - j < 0){
                            target = n-j+i;
                        }else{
                            target = i-j;
                        }
                        sb.append(names[target] + " was nasty about " + names[i]+"\n");
                    }
                }
            }
            if(flag == false)
                sb.append("Nobody was nasty\n");
        }
        sb.delete(0,1);
        sb.delete(sb.length()-1,sb.length());
        bw.write(sb.toString());
        bw.close();
    }
}
