package baekjoon;

import java.io.*;
import java.util.*;

public class Main {

    public static class Pair {
        int cord;
        String target;

        Pair(int cord, String target){
            this.cord = cord;
            this.target = target;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> test = new ArrayList<>();
        try{
            test.add("test");
            throw new Exception();
        }catch (Exception e){

        }
        bw.close();
    }
}
