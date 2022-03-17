import java.io.*;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< n ; i ++){
            String targetString = br.readLine();
            bw.write(Pattern.matches("(100+1+|01)+", targetString) ? "YES\n" : "NO\n");
            bw.flush();
        }
        bw.close();
    }
}
