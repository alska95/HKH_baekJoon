import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int e= Integer.parseInt(st.nextToken());
        int s =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int tmpE = 1;
        int tmpS = 1;
        int tmpM = 1;
        int count = 1;
        while(!(tmpE == e) ||!(tmpS == s) || !(tmpM == m)){
            if(++tmpE > 15){
                tmpE -= 15;
            }
            if(++tmpS > 28){
                tmpS -= 28;
            }
            if(++tmpM > 19){
                tmpM-= 19;
            }
            count++;
        }
        bw.write(count+"");
        bw.close();
    }
}