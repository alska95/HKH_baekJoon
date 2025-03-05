package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int sizeY;
    static int sizeX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        sizeY = Integer.parseInt(st.nextToken());
        sizeX = Integer.parseInt(st.nextToken());
        int board[][] = new int[sizeY][sizeX];
        ArrayList<int[]> cheeseList = new ArrayList<>(); // y, x
        for(int i = 0 ; i < sizeY ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < sizeX ; j++){
                int target = Integer.parseInt(st.nextToken());
                board[i][j] = target;
                if(target == 1)
                    cheeseList.add(new int[]{i, j});
            }
        }

        int count = 0;
        int size = 0;
        //bfs로 공기에 닿은부분을 만들자.
        makeVulnerable(board , 0 , 0);
        while(!cheeseList.isEmpty()){
            count++;
            int iter = 0;
            size = cheeseList.size();
            ArrayList<int []> removeList = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                int[] cur = cheeseList.get(iter++);
                for(int j = 0 ; j < 4; j++){
                    if(board[cur[0]+dy[j]][cur[1]+dx[j]] == -1){
                        cheeseList.remove(--iter);
                        removeList.add(new int[]{cur[0], cur[1]});
                        break;
                    }
                }
            }

            for(int i = 0 ; i < removeList.size() ; i++){
                int target[] = removeList.get(i);
                board[target[0]][target[1]] = -1;
                makeVulnerable(board , target[0] , target[1]);
            }

        }
        bw.write(count+"\n");
        bw.write(size+"\n");
        bw.close();
    }

    private static void makeVulnerable(int[][] board, int y, int x) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        board[y][x] = -1;
        bfsQueue.add(new int[]{y,x});
        while(!bfsQueue.isEmpty()){
            int [] cur = bfsQueue.poll();
            for(int i = 0 ; i < 4 ; i++){

                int nextX = cur[1]+ dx[i];
                int nextY = cur[0]+ dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= sizeX || nextY >= sizeY)
                    continue;
                if(board[nextY][nextX] == 0){
                    board[nextY][nextX] = -1;
                    bfsQueue.add(new int[]{nextY,nextX});
                }
            }
        }
    }
}
