package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < t ; z++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int pa = a+b*d;
            int dn = b*c;
            if(pa < dn){
                bw.write("parallelize\n");
            }else if(dn < pa){
                bw.write("do not parallelize\n");
            }else{
                bw.write("does not matter\n");
            }

        }

        bw.close();
    }
}
