package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int n = Integer.parseInt(st.nextToken());
		int maintain = Integer.parseInt(st.nextToken());
		int visited[] = new int[maintain+1];

		for(int i = 0 ; i < n ; i++){
			int target = Integer.parseInt(br.readLine());
			for(int j = 1 ; j <= maintain ; j++){
				if(j*target > maintain)
					break;
				visited[j*target] = 1;
			}
		}

		int result = 0;
		for(int i = 0 ; i <= maintain ; i++){
			if(visited[i] == 1){
				result++;
			}
		}
		bw.write(result+"");
		bw.close();
	}

}
