import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> board = new ArrayList<>();
		int target = Integer.parseInt(br.readLine());
		int start = 0;
		int totalNum = 0;

		for(int i = 1 ; i <= target ; i++){
			start+=i;
			totalNum += start;
			if(totalNum > target)
				break;
			board.add(totalNum);
		}

		int dp[] = new int[target+1];

		for(int i = 0 ; i < target+1 ; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 0 ; i < board.size() ; i++){
			dp[board.get(i)] = 1;
		}
		for(int i = 2 ; i<= target ; i++){
			for(int j = 0 ; j< board.size() ; j++){
				if(i-board.get(j) > 0)
					dp[i] = Math.min(dp[i - board.get(j)]+1, dp[i]);
			}
		}

//        for (Integer integer : board) {
//            System.out.println("integer = " + integer);
//        }
//        for (int i : dp) {
//            System.out.println("i = " + i);
//        }
		bw.write(dp[target]+"");
		bw.close();
	}

}
