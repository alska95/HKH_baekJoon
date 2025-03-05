package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static String[][] board;
    static Set<String> results = new HashSet<>();

    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    public static void dfs(int y , int x, int count , StringBuilder sb){
        if(count == 6){
            results.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX < 0 || nextX > 4 || nextY < 0 || nextY > 4)
                continue;
            dfs(nextY, nextX , count+1, new StringBuilder().append(sb).append(board[nextY][nextX]));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        board = new String[5][5];
        for(int i = 0 ; i < 5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() ," ");
            for(int j = 0 ; j < 5 ; j++){
                board[i][j] = st.nextToken();
            }
        }
        for(int i = 0 ; i < 5 ; i ++){
            for(int j = 0 ; j < 5 ; j++){
                dfs(i , j , 1 , new StringBuilder().append(board[i][j]));
            }
        }
        bw.write(results.size()+"");
        bw.close();
    }
}
