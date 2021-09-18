import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sameFlag = 0;
        int sameNum = 0;
        int max = 0;
        int a [] = new int [3];
        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        for(int i = 0 ; i < 3 ; i++ ){
            a[i] = Integer.parseInt(st.nextToken());
            if(a[i] > max)
                max = a[i];
            for(int j = 0 ; j < i ; j++){
                if(a[i] == a[j]){
                    sameFlag++;
                    sameNum = a[i];
                }
            }
        }
        if(sameFlag == 1){
            sameFlag = 1000+sameNum*100;
        }else if(sameFlag > 1){
            sameFlag = 10000+sameNum*1000;
        }else{
            sameFlag = max*100;
        }
        bw.write(sameFlag+"");
        bw.close();
    }
}