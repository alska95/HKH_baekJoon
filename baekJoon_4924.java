
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken());

        bw.write(t*(d/(s*2))+"");
        bw.close();

    }
}