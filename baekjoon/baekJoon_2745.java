package baekjoon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ans = 0;
        String s = scan.next();
        int b = scan.nextInt();
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && '9'>=s.charAt(i))
                ans = ans*b+(s.charAt(i)-'0');
            else
                ans = ans*b+(s.charAt(i)-'A'+10);
        }
        System.out.println(ans);
    }

}
