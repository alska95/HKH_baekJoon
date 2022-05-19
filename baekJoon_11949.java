import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int student = Integer.parseInt(st.nextToken());
		int card = Integer.parseInt(st.nextToken());
		int status[] = new int[student];
		for(int i = 0 ; i < student; i++){
			status[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1 ; i <= card; i++){
			for(int j = 0 ; j < student-1 ; j++){
				if(status[j] % i > status[j+1] % i){
					int tmp = status[j];
					status[j] = status[j+1];
					status[j+1] = tmp;
				}
			}
		}
		for(int i = 0 ; i < student; i++){
			bw.write(status[i]+"\n");
		}
		bw.close();
	}
}