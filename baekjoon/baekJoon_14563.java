package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int target = Integer.parseInt(st.nextToken());
            List<Integer> board = new ArrayList<>();
            for(int j = 1; j <= Math.sqrt(target) ; j++){
                if(target % j == 0 && target != j){
                    board.add(j);
                    int otherTarget = target / j;
                    if(j != otherTarget && target != otherTarget){
                        board.add(otherTarget);
                    }
                }
            }
            int sum = board.stream().reduce(Integer::sum).orElse(0);
            if(target == sum){
                bw.write("Perfect\n");
            }else if(target > sum){
                bw.write("Deficient\n");
            }else{
                bw.write("Abundant\n");
            }
        }

        bw.close();
    }
}
