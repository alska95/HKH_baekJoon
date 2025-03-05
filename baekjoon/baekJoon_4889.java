package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int MIN = 2000000000;
    public static int min(int a, int b){
        return a < b ? a : b;
    }
    public static void Combination2(ArrayList<Integer> selected, ArrayList<Integer> notSelected , int n , int [][] board){
        int sumS = 0;
        int sumN = 0;
        for(int i = 0; i < n/2; i++){
            for(int j = 0 ; j < n/2 ; j++){
                if(i!= j){
                    sumS += board[selected.get(i)-1][selected.get(j)-1];
                    sumN += board[notSelected.get(i)-1][notSelected.get(j)-1];
                }
            }
        }
        int result = Math.abs(sumN-sumS);
//        System.out.println(sumS);
//        System.out.println(sumN);

        MIN = min(result , MIN);
    }
    public static void Combination(int start , int r , int n , int [][] board , int [] visited){
        if(r == 0){
            //현재 조합이 결정되었음.
//            System.out.printf(" selected : ");
            ArrayList<Integer> selected = new ArrayList<>();
            ArrayList<Integer> notSelected = new ArrayList<>();
            for(int i = 1 ; i <= n ; i++){
                if(visited[i] == 1){
                    selected.add(i);
                }else{
                    notSelected.add(i);
                }
            }
            //결정된 조합(n/2개)을 n/2 C 2 로 재조합
            Combination2(selected , notSelected , n , board);
            return;
        }

        for(int i = start ; i <= n ; i++){
            visited[i] = 1;
            Combination(i+1 , r-1 , n , board , visited);
            //start : i (i false true정하면 볼일 없기에 i+1)
            // r의 개수만큼 뽑아냄
            visited[i] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int [][] board = new int[n][n];
        int [] visited = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Combination(1, n/2, n, board , visited);
        System.out.println(MIN);
    }
}
