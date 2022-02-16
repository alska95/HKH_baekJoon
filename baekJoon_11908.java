import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0;
        int sum = 0;
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < t ; i++){
            int target = Integer.parseInt(st.nextToken());
            sum+=target;
            max = Math.max(max,target);
        }
        bw.write(sum-max+"");
        bw.close();
    }

}
