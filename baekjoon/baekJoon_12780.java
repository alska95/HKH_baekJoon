package baekjoon;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String h = br.readLine();
        String target = br.readLine();

        Matcher matcher = Pattern.compile(target).matcher(h);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        bw.write(count+"");
        bw.close();
    }
}
