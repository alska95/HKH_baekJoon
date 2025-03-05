package baekjoon;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < 6 ; i++){
			if(br.readLine().contains("FBI"))
				sb.append(i).append(" ");
		}

		if(sb.length() > 0)
			System.out.println(sb);
		else
			System.out.println("HE GOT AWAY!");
	}
}
