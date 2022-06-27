import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int board [] = new int[101];
        int min = 100;
        int max = 0;
        for(int i = 0 ; i < 3;  i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            min = Math.min(from, min);
            max = Math.max(to, max);
            for(int j = from; j<to ; j++){
                board[j]++;
            }
        }
        int sum = 0;
        for(int i= min ; i <= max ; i++){
            switch (board[i]){
                case 1:
                    sum+=a;
                    break;
                case 2:
                    sum+=2*b;
                    break;
                case 3:
                    sum+=3*c;
                    break;
            }
        }
        bw.write(sum+"");
        bw.close();
    }
}
