import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb =new StringBuilder();
		while(true){
			String target = br.readLine();
			if(target.equals("#"))
				break;
			char a = target.charAt(0);
			String b = target.substring(2).toLowerCase();
			int result = 0;
			for(int i = 0 ; i < b.length() ; i++){
				if(a == b.charAt(i))
					result++;
			}
			sb.append(a).append(" ").append(result).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.close();
	}
}
