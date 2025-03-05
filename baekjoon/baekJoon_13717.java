package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String minResult = "";
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            String target = br.readLine();
            if(i == 0)
                minResult= target;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int balance = Integer.parseInt(st.nextToken());
            int number = 0;
            while(balance/cost != 0){
                number++;
                balance+=2-cost;
            }
            sum+=number;
            if(number > max){
                max = number;
                minResult = target;
            }
        }
        bw.write(sum+"\n");
        bw.write(minResult);
        bw.close();
    }
}
