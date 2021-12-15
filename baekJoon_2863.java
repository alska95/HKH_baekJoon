import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double board [][] = new double[2][2];
        StringTokenizer st =new StringTokenizer(br.readLine() , " ");
        board[0][0] = Integer.parseInt(st.nextToken());
        board[0][1] = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine() , " ");
        board[1][0] = Integer.parseInt(st.nextToken());
        board[1][1] = Integer.parseInt(st.nextToken());

        double max = 0;
        int maxIter = 0;
        for(int i = 0 ; i < 4 ; i++){
            double result = board[0][0]/board[1][0] + board[0][1]/board[1][1];

            if(max < result){
                max = result;
                maxIter = i;
            }
            double tmp = board[0][0];
            board[0][0] = board[1][0];
            board[1][0] = board[1][1];
            board[1][1] = board[0][1];
            board[0][1] = tmp;
        }
        bw.write(maxIter+"");
        bw.close();
    }
}