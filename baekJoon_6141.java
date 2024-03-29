import java.io.*;
import java.util.*;

public class Main {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        long cnt = Integer.parseInt(br.readLine());
        long n = N - 1;
        if (cnt > 0) {
            if (N % 4 == 1) n += 8 * cnt;
            else n += cnt / 2 * 8 + cnt % 2 * (8 - (N - 1) * 2);
        }
        bw.write(String.valueOf(n));
        bw.close();
    }

}