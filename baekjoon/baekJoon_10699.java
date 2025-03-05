package baekjoon;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        bw.write(format.format(date).toString());
        bw.close();
    }
}
