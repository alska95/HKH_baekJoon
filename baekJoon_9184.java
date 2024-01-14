import java.util.Scanner;

public class Main {

    static int[][][] dp_arr = new int[21][21][21];

    public static int w(int a, int b, int c) {
        //BC
        if(a<=0 || b<=0 || c<=0) {
            return 1;
        }
        if(a>20 || b>20 || c>20) {
            return w(20, 20, 20);
        }

        //Memoization
        if(dp_arr[a][b][c] != 0) {
            return dp_arr[a][b][c];
        }

        //Condition1
        if(a<b && b<c) {
            dp_arr[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return dp_arr[a][b][c];
        }

        //Condition2(otherwize)
        dp_arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp_arr[a][b][c];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 0;
        int b = 0;
        int c = 0;

        while(true) {
            //Inputs
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            //Break condition
            if(a==-1 && b==-1 && c==-1) {
                break;
            }

            //Outputs
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }

        scanner.close();
    }
}