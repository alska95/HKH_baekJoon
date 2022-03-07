import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int box = Integer.parseInt(st.nextToken());
        int book = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int bs = 0;
        for(int i = 0 ; i < box ; i++){
            bs+= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int bks = 0;
        for(int i = 0 ; i < book ; i++){
            bks+= Integer.parseInt(st.nextToken());
        }

        bw.write(bs-bks+"");
        bw.close();

    }
}
