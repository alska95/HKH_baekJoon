package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static class LossSum{
        int loss;
        int happy;

        public LossSum() {
        }
    }
    static int n;
    static ArrayList<LossSum> lossSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        lossSum = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            lossSum.add(new LossSum());
        }
        for(int i = 0 ; i < n ; i ++){
            lossSum.get(i).loss = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i ++){
            lossSum.get(i).happy = Integer.parseInt(st.nextToken());
        }
        int result = dfs(0, 100);
        bw.write(result+"");
        bw.close();
    }

    public static int dfs(int i, int threshold){
        if(i == n)
            return 0;
        LossSum cur = lossSum.get(i);
        int proceed = 0;
        if(threshold - lossSum.get(i).loss > 0){
            proceed = dfs(i+1, threshold - cur.loss) + cur.happy;
        }
        int skip = dfs(i+1, threshold);
        return Math.max(proceed, skip);
    }
}
