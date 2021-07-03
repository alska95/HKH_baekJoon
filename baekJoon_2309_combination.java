import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

    static int [] midget = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 9 ; i++){
            midget[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(midget);
        int sum = Arrays.stream(midget).sum();
        for(int i = 0 ; i < 8 ; i++){
            for(int j = i+1 ; j < 9 ;j++){
                if(sum - midget[i] - midget[j] == 100){
                    for(int k = 0 ; k < 9 ; k++){
                        if( k != i && k != j){
                            System.out.println(midget[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
    }
}