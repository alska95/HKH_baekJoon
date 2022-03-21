import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());
        int c = Integer.valueOf(br.readLine());
        int d = Integer.valueOf(br.readLine());
        int f = Integer.valueOf(br.readLine());

        int result = 0;
        if(a < 0){
            result+=d;
            result += c*(-1*a);
            a = 0;
        }
        result += (b-a)*f;

        bw.write(result+"");
        bw.close();

    }
}