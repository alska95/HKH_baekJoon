import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] targetString = br.readLine().toCharArray();
        String [] suffix = new String[targetString.length];
        for(int i = 0 ; i < targetString.length; i++){
            suffix[i] = "";
            for(int j = targetString.length-i-1 ; j < targetString.length ; j++){
                suffix[i] += targetString[j];
            }
        }
        Arrays.sort(suffix);
        for (String s : suffix) {
            System.out.println(s);
        }
    }
}