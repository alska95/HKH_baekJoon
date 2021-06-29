import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        str = br.readLine();
        Queue<Character> as = new LinkedList<>();
        for(int i = 0 ; i < str.length() ; i++){
            as.add(str.charAt(i));
        }
        while(!as.isEmpty()){
            for(int i = 0 ; i< 10 ; i++){
                if(as.isEmpty())
                    break;
                System.out.printf(as.poll().toString());
            }
            System.out.println();
        }
    }
}