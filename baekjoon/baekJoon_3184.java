package baekjoon;

import java.io.*;
import java.util.*;


public class Main {

    static int visited[][];
    static int height;
    static int width;
    static char board[][];
    static int wolves;
    static int sheep;
    static class Cord{
        int y;
        int x;

        public Cord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void bfs(int y, int x){
        Queue<Cord> bfsQueue = new LinkedList<>();
        int dx [] = {0,0,1,-1};
        int dy [] = {1,-1,0,0};
        bfsQueue.add(new Cord(y, x));
        int validFlag = 0;
        int sheepCount = 0;
        int wolfCount = 0;
        while(!bfsQueue.isEmpty()){
            Cord cur = bfsQueue.poll();
            visited[cur.y][cur.x] = 1;
            char target =board[cur.y][cur.x];
            if(target == 'v'){
                wolfCount++;
            }else if(target == 'o'){
                sheepCount++;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nextX = cur.x +dx[i];
                int nextY = cur.y +dy[i];
                if(nextX < 0 || nextX >= width || nextY < 0 || nextY>=height){
                    validFlag = 1;
                    continue;
                }
                if( board[nextY][nextX]!= '#' && visited[nextY][nextX] == 0){
                    visited[nextY][nextX] = 1;
                    bfsQueue.add(new Cord(nextY, nextX));
                }
            }
        }


        if(validFlag != 1){

            if(wolfCount< sheepCount){
                sheep += sheepCount;
            }else{
                wolves+= wolfCount;
            }  
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        board = new char[height][width];
        visited = new int[height][width];
        for(int i = 0; i < height ; i++){
            String target = br.readLine();
            for(int j = 0 ; j < width ; j++){
                board[i][j] = target.charAt(j);
            }
        }
        for(int i = 0; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(visited[i][j] == 0 && board[i][j] != '#'){
                    bfs(i,j);
                }
            }
        }
        bw.write(sheep +" "+wolves);
        bw.close();
    }
}
