package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        while (target.length()%3 != 0){
            target= "0"+target;
        }
        Map<String, String> board = new HashMap<>();
        board.put("000","0");
        board.put("001","1");
        board.put("010","2");
        board.put("011","3");
        board.put("100","4");
        board.put("101","5");
        board.put("110","6");
        board.put("111","7");
        String result = "";
        for(int i = 0  ; i < target.length() ; i+=3){
            String tmp = ""+
                    target.charAt(i)+
                    target.charAt(i+1)+
                    target.charAt(i+2);
            result += board.get(tmp);
        }
        bw.write(result);
        bw.close();
    }
}
