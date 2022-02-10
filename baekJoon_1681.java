import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int i = 0;
        int count = 0;
        while(true){
            if(count == n)
                break;
            i++;
            int tmp = i;
            boolean flag = false;
            while(tmp!=0){
                if(tmp % 10 == l){
                    flag = true;
                    break;
                }
                tmp/=10;
            }
            if(flag == false){
                count++;
            }
        }
        bw.write(i+"");
        bw.close();
    }

}
