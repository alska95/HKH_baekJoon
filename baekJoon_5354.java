import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int z = 0 ; z < t ; z++){
			int l = Integer.parseInt(br.readLine());
			for(int i = 0 ; i < l ; i++){
				for(int j = 0 ; j < l ; j++){
					if(i == 0 || j==0 || i==l-1 || j==l-1)
						sb.append("#");
					else{
						sb.append("J");
					}
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

}
