
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> board = new ArrayList<>();
        board.add(0);
        for(int i = 1 ; i < 100 ; i++){
            for(int j = 0 ; j < i ; j++){
                board.add(i);
                if(board.size()>b)
                    break;
            }
            if(board.size()>b)
                break;
        }
        int result = 0;
        for(int i = a ; i <= b ; i++){
            result+=board.get(i);
        }
        bw.write(result+"");
        bw.close();
    }
}