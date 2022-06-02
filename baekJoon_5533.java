import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int board[][] = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 3 ; j++){
                int target = Integer.parseInt(st.nextToken());
                board[i][j] = target;
            }
        }

        int sum[] = new int[n];
        for(int i = 0 ; i < 3 ; i++){
            int duplicate[] = new int[300];
            for(int j = 0 ; j < n ; j++){
                duplicate[board[j][i]]++;
            }
            for(int j = 0 ; j < n ; j++){
                if(duplicate[board[j][i]] == 1){
                    sum[j] += board[j][i];
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            bw.write(sum[i] + "\n");
        }
        bw.close();
    }
}
