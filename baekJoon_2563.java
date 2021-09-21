import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int board [][] = new int[101][101];

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = leftX+10;
            int rightY = leftY+10;
            for(int j = leftY; j < rightY ;j++){
                for(int k = leftX ; k < rightX ; k++){
                    board[j][k] =1;
                }
            }
        }
        int result = 0;
        for(int i = 0 ; i <=100 ;i++){
            for(int j = 0 ; j <= 100 ; j++){
                if(board[i][j] ==1)
                    result++;
            }
        }
        bw.write(result+"");
        bw.close();
    }
}
