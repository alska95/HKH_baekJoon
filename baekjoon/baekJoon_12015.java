package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int board[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0 ; i < n ; i++){
            if(list.get(list.size()-1) < board[i]){
                list.add(board[i]);
            }else{
                int left = 0;
                int right = list.size()-1;
                while(left < right){
                    int mid = (left + right)/2;
                    if(list.get(mid)<board[i]){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                list.set(right, board[i]);
            }
        }
        bw.write(list.size()-1+"");
        bw.close();
    }
}
