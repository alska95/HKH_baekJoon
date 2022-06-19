import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long board[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }
        long cluster = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(board[i] != 0){
                long target = board[i] / cluster;
                if(board[i] % cluster == 0){
                    sum += target * cluster;
                }else{
                    sum += (target+1)*cluster;
                }
            }
        }
        bw.write(sum+"");
        bw.close();
    }
}
