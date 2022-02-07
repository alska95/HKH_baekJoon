import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		Integer board[] = new Integer[4];
		for(int i = 0 ; i < 4; i++){
			board[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(board);
		bw.write(board[0]*board[2]+"");
		bw.close();
	}

}
