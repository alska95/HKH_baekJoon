import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < target ; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0)
                result -= 1;
            else
                result +=1;
        }
        if(result > 0)
            bw.write("Junhee is cute!");
        if(result < 0)
            bw.write("Junhee is not cute!");
        bw.close();
    }
}