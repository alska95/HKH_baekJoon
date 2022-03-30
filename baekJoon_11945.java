import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String board[] = new String[n];

        for(int i = 0 ; i < n ; i++){
            board[i] = br.readLine();
        }
        for(int i = 0 ; i < n ; i ++){
            for(int j = m-1 ; j >= 0 ; j--){
                bw.write(board[i].charAt(j));
            }
            bw.write("\n");
        }
        bw.close();
    }
}