package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int targets[] = new int[3];
        targets[0] = Integer.parseInt(st.nextToken());
        targets[1] = Integer.parseInt(st.nextToken());
        targets[2] = Integer.parseInt(st.nextToken());

        int dogACycle = a+b;
        int dogBCycle = c+d;
        for(int i = 0 ; i < 3; i++){
            int result = 0;
            if(targets[i]%dogACycle <= a && targets[i]%dogACycle!=0 )
                result++;
            if(targets[i]%dogBCycle <= c && targets[i]%dogBCycle!=0)
                result++;
            bw.write(result+"\n");
        }
        bw.close();
    }
}
