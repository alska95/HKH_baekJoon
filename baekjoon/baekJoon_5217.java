package baekjoon;

import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer> > result;
    static int [] visited;
    static int target;

    public static void combination(int start, int n, int r){
        if(n == r){
            int sum = 0;
            List<Integer> selected = new ArrayList<>();
            for(int i = 1 ; i < target+1 ; i++){
                if(visited[i] == 1 ){
                    sum+=i;
                    selected.add(i);
                }
            }
            if(sum == target){
                result.add(selected);
            }
            return ;
        }

        for(int i = start ; i < target+1 ; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                combination(i, n+1, r);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());



        StringBuilder sb= new StringBuilder();
        for(int z = 0 ; z < testCase ; z++){
            target = Integer.parseInt(br.readLine());
            visited = new int[target+1];
            result = new ArrayList<>();
            combination(1,0,2);
            sb.append("Pairs for ").append(target).append(":");
            for(int i = 0 ; i < result.size(); i++){
                int a = result.get(i).get(0);
                int b = result.get(i).get(1);
                sb.append(" ").append(a).append(" ").append(b);
                if(i < result.size()-1)
                    sb.append(",");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

}
