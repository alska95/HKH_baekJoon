package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int loc = Integer.parseInt(st.nextToken());
			String target = st.nextToken();
			sb.append(target.substring(0,loc-1)).append(target.substring(loc)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
