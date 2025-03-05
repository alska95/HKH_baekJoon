package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static int visited[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int r,c,k, result;
    static String board [];
    public static void dfs(int y , int x ,int count){
        if(count == k && y == 0 && x == c-1){
            result++;
            return;
        }
        if(count > k)
            return;
        for(int i = 0 ; i < 4; i++){
            int nextX = x+ dx[i];
            int nextY = y+ dy[i];
            if(nextX < 0 || nextX >= c || nextY < 0 || nextY >= r)
                continue;
            if(board[nextY].charAt(nextX) == 'T' || visited[nextY][nextX] == 1)
                continue;
            visited[nextY][nextX] = 1;
            dfs(nextY, nextX , count+1);
            visited[nextY][nextX] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new String[r];

        for(int i = 0 ; i < r ; i++){
            board[i] = br.readLine();
        }
        visited = new int[r][c];
        int startX = 0;
        int startY = r-1;
        visited[startY][startX] = 1;
        dfs(startY, startX , 1);
        bw.write(result+"");
        bw.close();
    }
}
