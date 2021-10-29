import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int result = 0;
        while(st.hasMoreTokens())
            result+= Integer.parseInt(st.nextToken());
        bw.write(result+"");
        bw.close();
    }
}