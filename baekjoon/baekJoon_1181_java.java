package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> board = new ArrayList<>();
        for(int i = 0 ; i < N ;i++){
            String target = br.readLine();
            if(!board.contains(target))
                board.add(target);
        }
        Collections.sort(board , new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }else{
                    return a.length() - b.length();
                }
            }
        });

        for (String s : board) {
            bw.write(s+"\n");
        }

        bw.close();
    }
}
