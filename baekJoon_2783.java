import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Double> pq = new PriorityQueue<>();
		pq.add(Double.parseDouble(st.nextToken())/Double.parseDouble(st.nextToken()));
		for(int i = 1 ; i <= n ; i++){
			st =new StringTokenizer(br.readLine(), " ");
			pq.add(Double.parseDouble(st.nextToken())/Double.parseDouble(st.nextToken()));
		}
		bw.write(Math.round(pq.poll()*100000.0)/100.0+"");
		bw.close();
	}
}
