package baekjoon;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int [] arrayS = new int[N];
        StringTokenizer st = new StringTokenizer(sc.readLine()," ");
        for(int i = 0; i < N ; i++){
            arrayS[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrayS);

        int M = Integer.parseInt(sc.readLine());
        int [] targetArray = new int[M];
        st = new StringTokenizer(sc.readLine()," ");
        for(int i = 0 ; i < M ; i++){
            targetArray[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < M ; i++){
            int min = 0;
            int max = N-1;
            int middle = 0;
            while(max >= min){
                middle = (min + max)/2;
                if(arrayS[middle] > targetArray[i]){
                    max = middle -1;
                }
                else if(arrayS[middle] < targetArray[i]){
                    min = middle +1;
                }else{
                    break;
                }
            }
            if(arrayS[middle] == targetArray[i]){
                System.out.println(1);
            }else{
//                System.out.println(arrayS[middle] +" "+ targetArray[i]);
                System.out.println(0);
            }
        }
    }
}
