import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 7;i++){
            int target = Integer.parseInt(br.readLine());
            if(target%2 == 1){
                result += target;
                if(target < min)
                    min = target;
            }
        }
        if(result == 0)
            bw.write("-1");
        else
            bw.write(result + "\n" + min);
        bw.close();
    }
}
