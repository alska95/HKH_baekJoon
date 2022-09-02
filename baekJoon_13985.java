import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int board[] = new int[l+1];

        int expectedMax = 0;
        int expectedMaxP = 1;

        for(int i = 1 ; i<= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(b-a > expectedMax){
                expectedMax = b-a;
                expectedMaxP = i;
            }

            for(int j = a; j <= b ;j++){
                if(board[j] == 0){
                    board[j] = i;
                }
            }
        }

        int result[] = new int[n+1];

        for(int i = 1 ; i <= l ; i++){
            result[board[i]]++;
        }

        int max = 0;
        int maxP = 1;
        for(int i = 1 ; i <= n ; i++){
            if(result[i] > max){
                maxP = i;
                max = result[i];
            }
        }
        bw.write(expectedMaxP+"\n"+maxP);
        bw.close();
    }
}