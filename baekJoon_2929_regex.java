import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String targetString = br.readLine();
        int result = 0;
        for(int i = 0 ; i < targetString.length() ; i++){
            if(Pattern.matches( "[A-Z]" , String.valueOf(targetString.charAt(i))))
                if(i % 4 != 0){
                    StringBuilder sb = new StringBuilder();
                    sb.append(targetString.substring(0,i));
                    int tmp = 0;
                    while((i+tmp)%4 != 0){
                        sb.append("x");
                        tmp++;
                        result++;
                    }
                    sb.append(targetString.substring(i,targetString.length()));
                    targetString = sb.toString();
                }
        }
        bw.write(result+"");
        bw.close();
    }
}