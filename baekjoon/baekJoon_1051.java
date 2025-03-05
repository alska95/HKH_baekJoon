package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by kyeongha55@linecorp.com on 2024/01/14
 */
public class baekJoon_1051 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        int[][] board = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            String input = br.readLine();
            for (int j = 0; j < colSize; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        boolean breakFlag = false;
        int sideSize = Math.max(rowSize, colSize);
        for( ; sideSize >= 0 ; sideSize--){
            for(int i = 0 ; i < rowSize ; i++) {
                for(int j = 0; j < colSize ; j++) {
                    if(i + sideSize >= rowSize || j + sideSize >= colSize) {
                        break;
                    } else if (board[i][j] == board[i][j+sideSize] &&
                            board[i][j+sideSize] == board[i+sideSize][j] &&
                            board[i+sideSize][j] == board[i+sideSize][j+sideSize]
                    ){
                        breakFlag = true;
                        break;
                    }
                }
                if(breakFlag) {
                    break;
                }
            }
            if(breakFlag) {
                break;
            }
        }
        int result = (sideSize + 1) * (sideSize + 1);
        bw.write(result+"");
        bw.close();
    }
}
