import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] visited = new int [31];
        for(int i = 1 ; i <=28 ; i++){
            visited[Integer.parseInt(br.readLine())] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= 30 ; i ++){
            if(visited[i] == 0){
                sb.append(i).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

}
