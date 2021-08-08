import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int end = n;
        if(m < n)
            end = m;
        int lcd = 1;
        int gcd = m*n;
        for(int i = end ; i > 0 ; i--){
            if(n%i == 0 && m%i ==0){
                lcd = i;
                gcd /=i;
                break;
            }
        }
        bw.write(lcd +"\n" + gcd);
        bw.close();
    }
}
