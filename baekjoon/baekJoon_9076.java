package baekjoon;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer board[] = new Integer[5];
            for(int j = 0 ; j < 5 ; j++){
                board[j] = Integer.parseInt(st.nextToken());
            }
            int[] result = Arrays.stream(board).sorted().mapToInt(a->a).toArray();
            if(result[3] - result[1] >= 4){
                bw.write("KIN\n");
            }else{
                bw.write(result[1]+result[2]+result[3]+"\n");
            }
        }

        bw.close();
    }
}
