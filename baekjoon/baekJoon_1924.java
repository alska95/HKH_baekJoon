package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int [] alldays ={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] ans = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int tmp = day;
        for(int i = 1 ; i < month; i++){
            tmp+= alldays[i];
        }
        System.out.println(ans[tmp%7]);
    }
}


//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
//        int month = Integer.parseInt(st.nextToken());
//        int [] alldays ={0 ,3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
//        int day = Integer.parseInt(st.nextToken()) + alldays[month-1];
//        String[] ans = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//        System.out.println(ans[day%7]);
//    }
//}

