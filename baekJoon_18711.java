import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++){
			String target = br.readLine();
			int sumA = 0;
			for(int j = 0 ; j < 3 ; j++){
				sumA+= ((int)target.charAt(j)-65)*Math.pow(26, 2-j);
			}
			int sumB = Integer.parseInt(target.substring(4, 8));
			if(Math.abs(sumA - sumB) <= 100){
				sb.append("nice\n");
			}else{
				sb.append("not nice\n");
			}
		}
		System.out.println(sb);
	}
}
