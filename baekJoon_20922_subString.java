import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] input = new int[N];
        st = new StringTokenizer(br.readLine() , " ");
        for(int i= 0 ; i < N ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> target = new HashMap<>();
        int start = 0;
        while(start < N){
//            System.out.println(start);
            start = solve(start , N, M, input, target);
            target.clear();
        }
        System.out.println(max);
    }

    private static int solve(int start , int N, int M, int[] input, Map<Integer, Integer> target) {
        int count = 0;
        for(int i = start; i < N; i++){
            if(target.containsKey(input[i])){
                int tmp = target.get(input[i])+1;
                if(tmp > M){
                    if(max < count)
                        max = count;
                    target.put(input[i] , tmp-2);
                    int next = 0;
                    for(int j = start ; j < N ; j++){
                        if(input[j] == input[i]){
                            next = j+1;
                            break;
                        }
                    }
                    return next;
                }else{
                    target.put(input[i] , tmp);
                    count++;
                }
            }
            else{
//                System.out.println(input[i]);
                target.put(input[i] , 1);
                count++;
            }
        }
        if(max < count)
            max = count;
        return N;
    }
}
