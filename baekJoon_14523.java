
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        int visited[] = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0 ; i < target ; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(visited[cur] == 0){
                visited[cur] = 1;
            }else{
                count++;
            }
        }
        bw.write(count+"");
        bw.close();
    }
}