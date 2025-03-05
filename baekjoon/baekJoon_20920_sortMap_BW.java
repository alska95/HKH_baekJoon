package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String , Integer> result = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            String tmp = br.readLine();
            if(tmp.length() >= M){
                if(result.containsKey(tmp)){
                    result.put(tmp , result.get(tmp)+1);
                }else{
                    result.put(tmp , 1);
                }
            }
        }
        List<Map.Entry<String,Integer>> list = new LinkedList<>(result.entrySet());

        Collections.sort(list , (o1, o2)->{
            if(o1.getValue() == o2.getValue()){
                if(o1.getKey().length() == o2.getKey().length()){
                    return o1.getKey().compareTo(o2.getKey());
                }else{
                    return o2.getKey().length() - o1.getKey().length();
                }
            }else{
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            bw.write(stringIntegerEntry.getKey() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
