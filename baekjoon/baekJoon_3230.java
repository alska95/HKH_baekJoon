package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> board = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++){
            int tmp = Integer.parseInt(br.readLine());
            board.add(tmp-1, i);
        }
        ArrayList<Integer> finalBoard = new ArrayList<>();
        for(int i = m-1;  i >= 0 ; i--){
            int tmp = Integer.parseInt(br.readLine());
            finalBoard.add(tmp-1, board.get(i));
        }

        for(int i = 0 ; i < 3 ; i++){
            bw.write(finalBoard.get(i)+"\n");
        }
        bw.close();
    }
}
