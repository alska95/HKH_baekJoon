package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());

		if(a>b){
			long tmp = a;
			a = b;
			b= tmp;
		}

		bw.write((a+b)*(b-a+1)/2+"");
		bw.close();
	}
}
