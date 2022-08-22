import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            sb.append("god");
            while(st.hasMoreTokens()){
                sb.append(st.nextToken());
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}