package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int z = 0 ; z < N ; z++){
            Queue<Character> Q = new LinkedList<>();
            String targetString = sc.next();
            for(int i = 0 ; i < targetString.length(); i++){
                Q.add(targetString.charAt(i));
            }
            int validCount = 0;
            while(!Q.isEmpty()){
                char target = Q.poll();
                if(target == '('){
                    validCount +=1;
                }else{
                    validCount-=1;
                }
                if(validCount < 0){
                    break;
                }
            }
            if(validCount == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
