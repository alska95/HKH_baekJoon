
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int ballPointer = 1;
        int ballCounts[] = new int[n+1];
        int count = 0;
        while(true){
            if(++ballCounts[ballPointer] == m)
                break;
            count++;
            if(ballCounts[ballPointer] %2 ==1){
                ballPointer +=l;
                if(ballPointer>n)
                    ballPointer -= n;
            }else{
                ballPointer-=l;
                if(ballPointer < 1)
                    ballPointer+=n;
            }
        }
        bw.write(count+"");
        bw.close();
    }
}