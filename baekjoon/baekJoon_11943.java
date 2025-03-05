package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int board[][] = new int[2][2];
		for(int i = 0 ; i < 2 ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0 ; j <2 ; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bw.write(Math.min(board[0][1]+board[1][0] , board[0][0] + board[1][1])+"");
		bw.close();
	}

}
