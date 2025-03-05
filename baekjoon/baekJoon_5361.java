package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int j = 0 ; j < n ; j++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            double result = 0;
            for(int i = 0 ; i < 5 ; i++){
                double t = Double.parseDouble(st.nextToken());
                switch (i){
                    case 0:
                        result += t*350.34;
                        break;
                    case 1:
                        result += t*230.90;
                        break;
                    case 2:
                        result += t*190.55;
                        break;
                    case 3:
                        result += t*125.30;
                        break;
                    case 4:
                        result += t*180.90;
                        break;
                }
            }
            bw.write("$"+String.format("%.2f",result)+"\n");
        }
        bw.close();
    }

}
