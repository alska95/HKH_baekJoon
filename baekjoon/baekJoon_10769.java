package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern patternH = Pattern.compile(":-\\)");
        Pattern patternU = Pattern.compile(":-\\(");
        String target = br.readLine();
        Matcher matcherH = patternH.matcher(target);
        Matcher matcherU = patternU.matcher(target);
        long happy = matcherH.results().count();
        long unHappy = matcherU.results().count();

        if(happy+unHappy == 0){
            System.out.printf("none");
        }else if(happy > unHappy){
            System.out.printf("happy");
        }else if(unHappy>happy){
            System.out.printf("sad");
        }else{
            System.out.printf("unsure");
        }
    }
}
