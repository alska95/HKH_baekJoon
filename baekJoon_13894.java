import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        int []ans = new int[n+1];
        for(int target = 1 ; target <=n ; target++){
            int result = 0;
            int[] visited = new int[n+1];
            bfsQueue.offer(new int[]{target , 0});
            visited[target] =1;
            while(!bfsQueue.isEmpty()){
                int[] next = bfsQueue.poll();
                int nextNode = next[0];
                int nextDist = next[1]+1;
                for(int i = 0 ; i < graph.get(nextNode).size() ; i++){
                    int nextG = graph.get(nextNode).get(i);
                    if(visited[nextG] == 0){
                        result+=nextDist;
                        visited[nextG] = 1;
                        bfsQueue.add(new int[]{nextG, nextDist});
                    }
                }
            }
            ans[target] = result;
        }
//
//        for (int an : ans) {
//            System.out.printf(an+" ");
//        }
//        System.out.println();

        int min = Integer.MAX_VALUE;
        int minIter = 0;

        for(int i = 1 ; i < ans.length ; i++){
            if(ans[i] < min){
                min = ans[i];
                minIter = i;
            }
        }
        bw.write(minIter+"");
        bw.close();
    }
}
