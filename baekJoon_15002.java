import java.io.*;
import java.util.*;

public class Main {

    static Long max = 0L;
    static int s,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        s = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int q = s / k;
        int r = s % k;
        long max =1;
        for (int i =1; i <= k; i++) {
            if(i <= r) {
                max *= (q +1);
            }else {
                max *= q;
            }
        }
        bw.write(max+"");
        bw.close();
    }
}