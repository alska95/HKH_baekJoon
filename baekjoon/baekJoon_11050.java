package baekjoon;

import java.io.*;
import java.util.StringTokenizer;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 1;
        int div = 1;
        for(int i = 0 ; i < k ; i++){
            result *= n-i;
            div*=i+1;
        }
        bw.write(result/div+"");
        bw.close();
    }
}
