package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int [][] arr = new int [3][2];

    public static int solve(int target){
        if(arr[0][target] == arr[1][target]){
            return arr[2][target];
        }else if(arr[0][target] == arr[2][target]){
            return arr[1][target];
        }else{
            return arr[0][target];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < 3 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(solve(0)+ " ");
        bw.write(solve(1) + "");
        bw.close();
    }
}
