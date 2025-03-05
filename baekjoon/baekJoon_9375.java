package baekjoon;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int z = 0 ; z < testCase ; z++){
            Map<String , Integer> fashion = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int q = 0 ; q < n ; q++){
                StringTokenizer st = new StringTokenizer(br.readLine() , " ");
                String value = st.nextToken();
                String key = st.nextToken();
                if(fashion.containsKey(key)){
                    fashion.put(key , fashion.get(key)+1);
                }else{
                    fashion.put(key , 1);
                }
            }
            int result =1;
            for (Integer value : fashion.values()) {
                result*=value+1;
            }
            bw.write(result-1+"\n");
        }
        bw.close();
    }
}
