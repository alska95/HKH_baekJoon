import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for(int z = 0 ;z < t ; z++) {
			int min = Integer.MAX_VALUE;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 7; i++) {
				int cur = Integer.parseInt(st.nextToken());
				if(cur%2 == 0){
					min = Math.min(cur, min);
					sum += cur;
				}
			}
			bw.write(sum + " " + min + "\n");
		}
		bw.close();
	}

}
