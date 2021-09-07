
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3; i ++){
            int target = Integer.parseInt(br.readLine());
            if(min > target){
                min = target;
            }
        }
        int min2 = Integer.MAX_VALUE;
        for(int i = 0 ; i < 2 ; i++){
            int target = Integer.parseInt(br.readLine());
            if(min2 > target){
                min2 = target;
            }
        }
        bw.write(min + min2 - 50 + "");
        bw.close();
    }
}
