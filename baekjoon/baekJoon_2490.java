package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char [] result = {'D','C','B','A','E'};
        for(int i = 0 ; i< 3 ; i++){
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0 ; j < 4 ; j++){
                sum += Integer.parseInt(st.nextToken());
            }
            bw.write(result[sum] + "\n");
        }
        bw.close();
    }
}
