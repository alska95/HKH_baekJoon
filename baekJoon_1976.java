import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            board.add(new ArrayList<>());
        }
        for(int i = 1; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            for(int j = 1; j <= n ; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    board.get(i).add(j);
                    board.get(j).add(i);
                }
            }
        }
        int visited [] = new int[n+1];
        Queue<Integer> bfsQ = new LinkedList<>();
        int targetCity[] = new int[m+1];
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < m ; i++){
            targetCity[i] = Integer.parseInt(st.nextToken());
        }
        visited[targetCity[0]] = 1;
        bfsQ.add(targetCity[0]);
        while(!bfsQ.isEmpty()){
            int cur = bfsQ.poll();
            for(int i = 0 ; i < board.get(cur).size() ; i++){
                int next = board.get(cur).get(i);
                if(visited[next] == 0){
                    bfsQ.add(next);
                    visited[next] = 1;
                }
            }
        }
        int flag = 0;
        for(int i = 0 ; i < m ; i++){
            if(visited[targetCity[i]] == 0){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            bw.write("YES");
        else
            bw.write("NO");
        bw.close();
    }
}