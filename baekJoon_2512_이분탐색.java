import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine() , " ");
        int board [] = new int[n];
        int sum = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
            sum+=board[i];
            if(max < board[i])
                max = board[i];
        }

        int limit = Integer.parseInt(br.readLine());
        int result = n;
        if(sum <= limit)
            result = max;
        else{
            int left = 1;
            int right = limit;
            while (left <= right){
                int mid = (left+right)/2;
                int tmpSum = 0;

                for(int i = 0 ; i < n ; i++){
                    if(mid <= board[i])
                        tmpSum+=mid;
                    else
                        tmpSum+=board[i];
                }
                if(tmpSum > limit){
                    right = mid-1;
                }else{
                    left = mid +1;
                    result =mid;
                }
            }
        }
        bw.write(result+"");
        bw.close();
    }
}