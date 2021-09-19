import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n , l , r;
    static int board[][];
    static ArrayList<ArrayList<int []>> alliance;
    static int visited[][];
    static int stopFlag = 0;

    public static void bfs(int y , int x){
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        Queue<int[]> bfsQueue = new LinkedList<>();
        visited[y][x] = 1;
        alliance.add(new ArrayList<>());
        int aIter = alliance.size()-1;
        alliance.get(aIter).add(new int[]{y,x});
        bfsQueue.add(new int[]{y,x});
        while(!bfsQueue.isEmpty()){
            int [] cur = bfsQueue.poll();
            int curX = cur[1];
            int curY = cur[0];
            for(int i = 0 ; i < 4 ; i++){
                int nextX = curX+dx[i];
                int nextY = curY+dy[i];
                if(nextX < 0 || nextY <0 || nextX >=n || nextY>=n)
                    continue;
                int condition = Math.abs(board[nextY][nextX]-board[curY][curX]);
                if(condition >= l && condition <= r && visited[nextY][nextX] == 0){

                    alliance.get(aIter).add(new int[]{nextY ,nextX});
                    bfsQueue.add(new int[]{nextY , nextX});
                    visited[nextY][nextX] = 1;
                    stopFlag = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board =new int [n][n];
        visited =new int [n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0 ; j < n ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        alliance = new ArrayList<>();
        while(true){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(visited[i][j] == 0)
                        bfs(i , j);
                }
            }
            for(int i = 0 ; i < alliance.size() ; i++){
                int size = alliance.get(i).size();
                int sum = 0;
                for(int j = 0 ; j < size; j++){
                    int cur[] = alliance.get(i).get(j);
                    sum+= board[cur[0]][cur[1]];
                }
                int population = sum/size;
                for(int j = 0 ; j < size ; j++){
                    int cur[] = alliance.get(i).get(j);
                    board[cur[0]][cur[1]] = population;
                }
            }
            alliance.clear();
            visited = new int[n][n];

            if(stopFlag == 0)
                break;
            else{
                count++;
                stopFlag= 0;
            }
        }
        bw.write(count+"");
        bw.close();
    }
}
