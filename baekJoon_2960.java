
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int counter = 0;
        int dp[] = new int [n+1];
        int flag = 0;

        for(int i = 2 ; i <= n ; i++){
            for(int j = i ; j <= n ;j+=i){
                if(dp[j] != 1){
                    dp[j] = 1;
                    counter++;
                    if(counter == k){
                        bw.write(j+"");
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 1)
                break;
        }
        bw.close();
    }
}