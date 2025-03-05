package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int visited[][] = new int[101][101];
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for(int j = ly ; j <= ry ; j++){
                for(int k = lx ; k <= rx ; k++){
                    visited[j][k] += 1;
                }
            }
        }

        int result = 0;
        for(int i = 1 ; i <= 100 ; i++){
            for(int j = 1 ; j <= 100 ; j++){
                if(visited[i][j] > m)
                    result++;
            }
        }
        bw.write(result+"");
        bw.close();
    }
}
