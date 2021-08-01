import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int current = 0;
        int max = 0;
        for(int i = 0 ; i < 4 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            current+= -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if(max < current)
                max = current;
        }
        bw.write(max+"");
        bw.close();
    }
}