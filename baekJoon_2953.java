import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxIter = 0;
        int maxVal = 0;
        for(int i = 1; i <=5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int result = 0;
            for(int j = 0 ;  j < 4; j++){
                result+=Integer.parseInt(st.nextToken());
            }
            if(maxVal < result){
                maxVal = result;
                maxIter = i;
            }
        }
        bw.write(maxIter + " " + maxVal);
        bw.close();
    }
}
