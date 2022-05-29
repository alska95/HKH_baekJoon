import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true){
			String target = br.readLine();
			if(target.equals("END")){
				break;
			}
			for(int i = target.length()-1 ; i >=0 ; i--){
				sb.append(target.charAt(i));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}