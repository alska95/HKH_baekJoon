package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int target = Integer.parseInt(st.nextToken());
            if(cur == target){
                cur = cur == 2 ? 0 : cur+1;
                count++;
            }
        }
        bw.write(count+"");
        bw.close();
    }
}
