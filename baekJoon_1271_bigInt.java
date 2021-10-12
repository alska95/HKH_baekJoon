
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BigInteger target = new BigInteger(st.nextToken());
        BigInteger div = new BigInteger(st.nextToken());

        bw.write(target.divide(div)+"\n");
        bw.write(target.remainder(div).toString());

        bw.close();
    }
}