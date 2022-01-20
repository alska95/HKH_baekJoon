import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String target = br.readLine();
		String mask = br.readLine();
		int board[] = new int[mask.length()];
		for(int i = 0 ; i < mask.length() ; i++) {
			board[i] = mask.charAt(i)-96;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < target.length() ; i++){
			int iter = i%mask.length();
			char tc = target.charAt(i);
			if(tc == ' '){
				sb.append(' ');
				continue;
			}
			int rc = tc-board[iter];
			if(rc < 97)
				rc+=26;
			sb.append((char)rc);
		}
		bw.write(sb.toString());
		bw.close();
	}
}
