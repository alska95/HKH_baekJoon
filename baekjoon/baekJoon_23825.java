package baekjoon;

import java.util.*;

public class Main {
    public static void main(String[] a){
        StringTokenizer s = new StringTokenizer(new Scanner(System.in).nextLine(), " ");
        System.out.print(Math.min(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()))/2);
    }
}
