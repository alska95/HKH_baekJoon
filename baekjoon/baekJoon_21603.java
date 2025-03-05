package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>();

        int v1 = k % 10;
        int v2 = (k*2)%10;

        for(int i = 1 ; i <= n ; i++){
            int target = i % 10;
            if(target != v1 && target != v2)
                result.add(i);
        }
        bw.write(result.size()+"\n");
        if(result.size() != 0)
            for (Integer integer : result) {
                bw.write(integer+" ");
            }
        bw.close();
    }
}
