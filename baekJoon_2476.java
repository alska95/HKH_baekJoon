import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int board[] = new int[7];
            for (int j = 0; j < 3; j++) {
                board[Integer.parseInt(st.nextToken())]++;
            }
            int maxIter = 0;
            int max = 0;
            for (int j = 1; j < 7; j++) {
                if (board[j] >= max) {
                    max = board[j];
                    maxIter = j;
                }
            }
            if (max == 3) {
                sum = 10000 + maxIter * 1000;
            } else if (max == 2) {
                sum = 1000 + maxIter * 100;
            } else {
                sum = maxIter * 100;
            }
            result = Math.max(result, sum);
        }
        bw.write(result + "");
        bw.close();
    }
}