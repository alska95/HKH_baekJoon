import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            String name = st.nextToken();
            if(name.equals("#"))
                break;
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            String status = age > 17 || weight >= 80 ? "Senior" : "Junior";
            sb.append(name).append(" ").append(status).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        bw.close();
    }
}