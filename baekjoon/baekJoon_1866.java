package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> yose = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++){
            yose.add(i);
        }
        int next = 0;
        bw.write("<");
        while(!yose.isEmpty()){
            next += k;
            while(next > yose.size()){
                next -=yose.size();
            }
            bw.write(yose.remove(--next)+"");
            if(yose.isEmpty())
                bw.write(">");
            else
                bw.write(", ");
        }
        bw.close();
    }
}
