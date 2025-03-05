package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Log {
        int[] visited;
        int cityCount;
        int next;
        int flightCount= 0;

        public Log(int[] visited, int count, int next,int flightCount) {
            this.visited = visited;
            this.cityCount = count;
            this.next = next;
            this.flightCount = flightCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int z = 0 ; z < testCase ; z++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int vertexNum = Integer.parseInt(st.nextToken());
            int nodeNum = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Main.Log>> board = new ArrayList<>();
            for(int i = 0 ; i <= vertexNum ; i++){
                board.add(new ArrayList<>());
            }
            for(int i = 0 ; i < nodeNum ; i ++){
                st = new StringTokenizer(br.readLine() , " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                board.get(start).add(
                        new Main.Log(
                                new int[vertexNum+1],
                                1,
                                end,
                                0
                        ));
                board.get(end).add(
                        new Main.Log(
                                new int[vertexNum+1],
                                1,
                                start,
                                0
                        )
                );
            }
            int result = 0;
            Queue<Main.Log> bfsQueue = new LinkedList<>();
            for(int i = 0 ; i < board.get(1).size() ; i++){
                Main.Log target = board.get(1).get(i);
                target.flightCount++;
                target.visited[1] = 1;
                target.visited[target.next] = 1;
                target.cityCount++;
//                System.out.println("target.cityCount = " + target.cityCount);
                if(target.cityCount == vertexNum){
                    result = target.flightCount;
                    bfsQueue.clear();
                    break;
                }
                bfsQueue.add(target);
            }
            while(!bfsQueue.isEmpty()){
                Main.Log cur = bfsQueue.poll();
                for(int i = 0 ; i < board.get(cur.next).size() ; i++){
                    Main.Log target = board.get(cur.next).get(i);
                    target.flightCount = cur.flightCount+1;
                    if(target.visited[cur.next] == 0){
                        target.visited[cur.next] = 1;
                        target.cityCount = cur.cityCount+1;
                        if(target.cityCount == vertexNum){
                            result = target.flightCount;
                            bfsQueue.clear();
                            break;
                        }
                    }
                    bfsQueue.add(target);
                }
            }
            bw.write(result+"\n");
        }
        bw.close();
    }
}
