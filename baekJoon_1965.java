
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int max(int a , int b){
        return a > b ? a : b;
    }
    public static void main(String[] args) {
        int [] dp = new int[1001];
        for(int i = 0 ; i < dp.length ; i++){
            dp[i] = 1;
        }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> targetA = new ArrayList<Integer>();
        for(int i = 0 ; i < N ; i++){
            targetA.add(sc.nextInt());
        }

        for(int i = N-1 ; i >= 0 ; i--){
            for(int j = i+1 ; j < N ; j++){
                if(targetA.get(j) > targetA.get(i)){
                    dp[i] = max(dp[j]+1 , dp[i]);
                }
            }
        }
        int MAX = 0;
        for(int i = 0 ; i < N ;i++){
            MAX = max(MAX, dp[i]);
        }

        System.out.println(MAX);
    }
}
