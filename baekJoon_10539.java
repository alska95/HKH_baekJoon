import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();
        int prev = 0;

        for(int i = 1 ; i <= t ; i++){
            int cur = Integer.parseInt(st.nextToken());
            int target = cur * i - prev;
            prev += target;
            sb.append(target+" ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}