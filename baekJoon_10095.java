
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < testCase ; z++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int low = Integer.parseInt(st.nextToken());
            int pow = Integer.parseInt(st.nextToken());
            int result =1;
            for(int i = 1 ; i <= pow ; i++){
                result*= low;
                result%= 10;
            }
            if(result == 0)
                result = 10;
            bw.write(String.valueOf(result)+"\n");
        }
        bw.close();
    }

}