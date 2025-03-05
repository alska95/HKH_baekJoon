package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int count = 1;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            String board[] = new String[n+1];
            int visited[] = new int[n+1];
            for(int i = 1 ; i <= n ; i ++){
                board[i] = br.readLine();
            }
            for(int i = 0 ; i < 2*n-1 ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine() , " ");
                visited[Integer.parseInt(st.nextToken())] += 1;
            }
            for(int j = 1; j <= n ; j++){
                if(visited[j] == 1){
                    sb.append(count++).append(" ").append(board[j]).append("\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
