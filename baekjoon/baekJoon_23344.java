package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int team[] = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            team[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for(int k = 0 ; k < n ; k++){
            int sum = 0;
            for(int i = 0 ; i < 3 ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < 3 ; j++){
                    sum += Integer.parseInt(st.nextToken()) *team[j];
                }
            }
            result = Math.max(result, sum);
        }
        bw.write(result+"");
        bw.close();
    }
}
