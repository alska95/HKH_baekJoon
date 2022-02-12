import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int result = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
            if(result == 0){
                break;
            }
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

}

