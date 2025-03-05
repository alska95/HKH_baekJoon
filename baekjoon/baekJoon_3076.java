package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		String markA = "X";
		String markB = ".";

		for (int i = 1; i <= R * A; i++) {
			for (int j = 0; j < C * B; j++) {
				if((j/B)%2 == 0){
					bw.write(markA);
				}else{
					bw.write(markB);
				}
			}
			bw.write("\n");
			if((i%A)==0){
				String tmp = markB;
				markB = markA;
				markA = tmp;
			}
		}
		bw.close();
	}
}
