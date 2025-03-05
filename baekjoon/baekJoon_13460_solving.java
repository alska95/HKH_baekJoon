package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


class Cord{
    int x;
    int y;
    char color;
    int count;
    public Cord( int x, int y , char color , int count){
        this.x = x;
        this.y = y;
        this.color = color;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char [][] board = new char[height+1][width+1];
        int [][] visitedRed = new int[height+1][width+1];

        int [] red = new int[2];
        int [] blue = new int[2];
        for(int i = 0 ; i < height ;i++){
            String line = br.readLine();
            for(int j = 0 ; j < width ; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                }
                else if(board[i][j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }

        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};
        Stack<Cord> dfsStack = new Stack<>();
        dfsStack.add(new Cord(red[0],red[1],'R' , 0));
        dfsStack.add(new Cord(blue[0],blue[1],'B', 0));
        while(!dfsStack.empty()){
            
        }
    }
}

//dfs스택에 R과 B의 자리를저장한다/*
// 이동함에 따라 한쪽으로 계속해서 이동한다. #를 만날때 까지.
/*만약 만난다면 그자리를 visited로 체크한다.
만약 만난 자리가 visited로 이미 체크되어 있으면 이동할 수 없다.
만약 B가 먼저 O를 만나면 실패
만약 R이 O에 들어가면 그 시점의 카운트를 저장한다.
*
*
* */
//
// */
