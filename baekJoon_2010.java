import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            result += Integer.parseInt(br.readLine());
        }
        result -= n-1;

        bw.write(result+"");
        bw.close();
    }
}