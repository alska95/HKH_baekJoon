package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String ,Integer> board = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            String target = br.readLine();
            if(board.containsKey(target))
                board.put(target ,board.get(target)+1);
            else
                board.put(target , 1);
        }
        ArrayList<String> maxBook = new ArrayList<>();
        int max = 0;
        for( String key : board.keySet()){
            int keyValue = board.get(key);
            if(keyValue > max){
                max = keyValue;
                maxBook.clear();
                maxBook.add(key);
            }else if(keyValue == max){
                maxBook.add(key);
            }
        }
        Collections.sort(maxBook);
        bw.write(maxBook.get(0));
        bw.close();
    }
}
