import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
    int target;
    int cost;

    public Node(int target , int cost){
        this.target = target;
        this.cost = cost;
    }

}

public class Main {
    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<com.company.Node>> vertexArray = new ArrayList<>();
        int [] visited = new int[nodeNum+1];
        int [] dist = new int[nodeNum+1];

        for(int i = 0 ; i < nodeNum+1 ; i++){
            vertexArray.add(new ArrayList<>());
        }

        for(int i = 0 ; i < nodeNum-1 ; i++){
            String [] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            vertexArray.get(x).add(new com.company.Node(y,cost));
            vertexArray.get(y).add(new com.company.Node(x,cost));
        }

        Stack<com.company.Node> dfsStack = new Stack<>();
        dfsStack.add(new com.company.Node(1,0));
        dfs((ArrayList<ArrayList<com.company.Node>>) vertexArray, visited, dist, (Stack<com.company.Node>) dfsStack);
        int tmp = 0;
        int firstEnd = 0;
        for(int i = 0 ; i < nodeNum+1 ; i++){
            if(dist[i] > tmp){
                tmp = dist[i];
                firstEnd = i;
            }
            dist[i] = 0;
            visited[i] = 0;
        }
//        System.out.println(firstEnd);

        dfsStack.add(new com.company.Node(firstEnd,0));
        dfs((ArrayList<ArrayList<com.company.Node>>) vertexArray, visited, dist, (Stack<com.company.Node>) dfsStack);
//        for(int a : dist){
//            System.out.println(a);
//        }
        System.out.println(Arrays.stream(dist).max().getAsInt());
    }

    private static void dfs(ArrayList<ArrayList<com.company.Node>> vertexArray, int[] visited, int[] dist, Stack<com.company.Node> dfsStack) {
        while(!dfsStack.empty()){
            com.company.Node current = dfsStack.pop();
            int cost = current.cost;
            visited[current.target] = 1;
            for(int i = 0 ; i< vertexArray.get(current.target).size(); i++){
                com.company.Node next = vertexArray.get(current.target).get(i);
                if(visited[next.target] == 0){
                    dfsStack.add(new com.company.Node(next.target , cost + next.cost));
                    visited[next.target] = 1;
                    dist[next.target] = cost + next.cost;
                }
            }
        }
    }
}
