
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = -1;
        while(n != 0){
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            int count = 0;
            for(int i = n+1 ; i <= 2*n ; i++){
                int flag = 0;
                for(int j = 2 ; j <= Math.sqrt(i) ; j++){
                    if(i % j == 0){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    count++;
                }
            }
            bw.write(count+"\n");
        }
        bw.close();
    }
}
