package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int board[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = i+1 ; j < n ; j++){
                if(board[j] > board[i])
                    break;
                count++;
            }
            max = Math.max(count, max);
        }
        bw.write(max+"");
        bw.close();
    }
}
