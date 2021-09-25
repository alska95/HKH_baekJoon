
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long target = Long.parseLong(br.readLine());
        long sum = 0;
        int iter = 1;
        while(target >= sum){
            if(sum <= target)
                sum += iter++;
            if(sum > target)
                break;
        }
        iter -=2;
        bw.write(iter+"");
        bw.close();
    }
}
