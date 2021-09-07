package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> cityList;
    static ArrayList<int[]> chickenList;
    static int board[][];
    static int newBoard[][];
    static int visited[] = new int [20];
    static int visitedBoard[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int n;
    static int result = Integer.MAX_VALUE;

    static void combination(int start, int n , int r){
        if(r == 0){
            for(int i = 0 ; i < n ; i++){
                if(visited[i] == 1){
                    int [] target = chickenList.get(i);
                    board[target[0]][target[1]] = 2;
                }
            }
            System.out.println("let's go");

            result = Math.min(solveBfs(), result);
            for(int i = 0 ; i < n;i++){
                for(int j = 0 ; j < n ; j++){
                    board[i][j]= newBoard[i][j];
                }
            }
        }
        for(int i = start; i < n; i++){
            visited[i] = 1;
            combination(i+1 , n, r-1);
            visited[i] = 0;
        }
    }

    static int solveBfs(){
        int count = 0;
        for(int i = 0 ; i < cityList.size() ; i++){
            Queue<int[]> bfsQueue = new LinkedList<>();
            bfsQueue.add(new int[]{cityList.get(i)[0],cityList.get(i)[1] , 0});
            while(!bfsQueue.isEmpty()){
                int[] cur = bfsQueue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int cost = cur[2];
                int flag = 0;
                visitedBoard[curY][curX] = 1;

                for(int j = 0 ; j < 4 ; j++){
                    int nextX = curX+dx[j];
                    int nextY = curY+dy[j];
                    if(nextX >= n || nextX < 0 || nextY >=n || nextY < 0)
                        continue;
                    if(visitedBoard[nextY][nextX] == 0){
                        if(board[nextY][nextX] == 2){
                            System.out.println("nextX = " + nextX);
                            System.out.println("nextY = " + nextY);
                            System.out.println("cost = " + cost);
                            flag = 1;
                            count+=cost;
                            break;
                        }else{
                            bfsQueue.add(new int[]{nextY, nextX , cost++});
                            visitedBoard[nextY][nextX] = 1;
                        }
                    }
                }
                if(flag == 1){
                    break;
                }
            }
            bfsQueue.clear();
            for(int k = 0 ; k < n; k++){
                for(int z = 0 ; z < n ; z++){
                    visitedBoard[k][z] = 0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        newBoard = new int[n][n];
        visitedBoard = new int[n][n];
        cityList = new ArrayList<>();
        chickenList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0 ; j < n ; j++){
                int target = Integer.parseInt(st.nextToken());
                if(target == 2){
                    chickenList.add(new int[]{i, j});
                    continue;
                }
                if(target == 1){
                    cityList.add(new int[]{i,j});
                }
                board[i][j] = target;
                newBoard[i][j] = target;
            }
        }
        combination(0,chickenList.size(),m);
        bw.write(result+"");
        bw.close();
    }
}
