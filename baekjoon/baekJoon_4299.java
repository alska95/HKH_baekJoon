package baekjoon;

import java.io.*;


public class Main {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] list = br.readLine().split(" ");
		int N = Integer.parseInt(list[0]);
		int M = Integer.parseInt(list[1]);

		if ((N - M) < 0) {
			bw.write("-1");
		} else {
			if ((N - M) % 2 == 0){
				bw.write((N-M)/2 + M+ " " + (N-M)/2);
			} else {
				bw.write("-1");
			}
		}

		br.close();
		bw.close();
	}
}
