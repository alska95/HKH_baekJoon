package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        Map<String , Integer> dicMap = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String [] dictionary = new String[n+1];
        for(int i = 1 ; i <= n ; i++){
            String target = br.readLine();
            dictionary[i] = target;
            dicMap.put(target , i);
        }
        for(int i = 0 ; i < m ; i++){
            String target = br.readLine();
            if(target.matches("^\\d*")){
                bw.write(dictionary[Integer.parseInt(target)]+"\n");
            }else{
                bw.write(dicMap.get(target)+"\n");
            }
        }
        bw.close();
    }
}
