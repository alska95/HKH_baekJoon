import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int board[] = new int[3];
		for(int i = 0 ; i < 3 ; i++){
			board[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(board);
		int a  =board[2]-board[1];
		int b  =board[1]-board[0];
		System.out.println(a == b ? board[2]+a : a < b ? board[0]+a : board[1]+b);
	}
}
