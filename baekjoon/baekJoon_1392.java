package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> status = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            int second = Integer.parseInt(br.readLine());
            for(int j = 0 ; j < second ; j++){
                status.add(i);
            }
        }

        for(int i = 0 ; i < q ; i++){
            int target = Integer.parseInt(br.readLine());
            bw.write(status.get(target)+"\n");
        }
        bw.close();
    }
}
