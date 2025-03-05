package baekjoon;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int maxIter = 0;
		int board[] = new int[1000];
		double sum = 0;
		for(int i = 0 ; i < 10 ; i++){
			int target = Integer.parseInt(br.readLine());
			sum+=target;
			board[target] +=1;
			if(board[target] > max){
				maxIter = target;
				max = board[target];
			}
		}
		sum/=10;
		System.out.println((int)Math.round(sum) +"\n"+maxIter);
	}
}
