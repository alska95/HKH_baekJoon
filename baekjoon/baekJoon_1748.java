package baekjoon;

import java.io.*;

/**
 * 1의 자릿수 1 * 1~ 9 -> 9 * 1
 * 10의 자릿수 2 * 99~10  -> 90 * 2
 * 100 3 * 100 ~ 999 -> 900 * 3
*
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        int targetDiv = 0;
        int tmp = target;
        while(true){
            tmp/= 10;
            if(tmp == 0)
                break;
            targetDiv++;
        }


        int result = 0;
        for(int i = 1 ; i <= targetDiv ;i++){
            result+= Math.pow(10,i-1)*9*i;
        }
        int startIter = (int) Math.pow(10,targetDiv);
        result+= (target-startIter+1)*(targetDiv+1);
        bw.write(result+"");
        bw.close();
    }
}
