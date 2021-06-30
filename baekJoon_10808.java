
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] input = br.readLine().toCharArray();
        int [] result = new int[100];
        for(int i : input){
            result[i-96]++;
        }
        for(int i = 1 ; i < 27 ; i++){
            System.out.print(result[i] + " ");
        }
    }
}