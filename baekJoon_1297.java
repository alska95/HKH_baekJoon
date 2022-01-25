import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int board[] = new int[3];
		for(int i = 0 ; i < 3; i++){
			board[i] = Integer.parseInt(st.nextToken());
		}
		double x = Math.sqrt(Math.pow(board[0],2)/(Math.pow(board[1],2)+Math.pow(board[2],2)));
		StringBuilder sb = new StringBuilder();
		sb.append((int)(board[1]*x)).append(" ").append((int)(board[2]*x));
		bw.write(sb.toString());
		bw.close();
	}
}
