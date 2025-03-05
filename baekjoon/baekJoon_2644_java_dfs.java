package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int result = -1;

    public static int max(int a, int b){
        return a < b ? b : a;
    }
    public static void DFS(int start , int target , int [] visited , ArrayList<ArrayList<Integer>> node , int count){
        visited[start] = 1;
        count++;

        for(int i = 0 ; i < node.get(start).size() ; i++){
            int tmp = node.get(start).get(i);

            if(visited[tmp] == 0){
                if(tmp == target){
                    result = count;
                }
                DFS(tmp , target , visited , node , count);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexNum = sc.nextInt();
        int targetA = sc.nextInt();
        int targetB = sc.nextInt();
        int nodeNum = sc.nextInt();

        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
        for(int i = 0 ; i <= vertexNum ; i++){
            node.add(new ArrayList<>());
        }
        for (int i = 0 ; i < nodeNum ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            node.get(x).add(y);
            node.get(y).add(x);
        }

        int [] visited = new int[vertexNum+1];
//        dfs로 가장 먼저 도착하는게 촌수

        DFS(targetA , targetB , visited , node , 0);
        System.out.println(result);
    }
}
