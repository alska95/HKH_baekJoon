package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target =Integer.parseInt(br.readLine());
        int result = 2;
        int iter = 1;
        for(int i = 2 ; i <= target ; i++){
            if(iter >= target)
                break;
            result += i;
            iter++;
            if(iter >= target)
                break;
            result+= i;
            iter++;
        }
        bw.write(result+"");
        bw.close();
    }
}
