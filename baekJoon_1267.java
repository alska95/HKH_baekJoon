import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int resultY= 0;
        int resultM =0;

        for(int i = 0 ; i < n ; i ++){
            int target =Integer.parseInt(st.nextToken());
            resultY += 10 * (int) (Math.ceil(target/30)+1);
            resultM += 15 * (int) (Math.ceil(target/60)+1);
        }
        if(resultY == resultM){
            bw.write("Y M "+resultY );
        }
        else if(resultY < resultM){
            bw.write("Y "+resultY );
        }else
            bw.write("M "+resultM);

        bw.close();
    }
}