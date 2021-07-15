import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String targetPattern = br.readLine();
        targetPattern = targetPattern.replace("*" , ".*");
        Pattern pattern = Pattern.compile(targetPattern);
        for(int i = 0 ; i < n ; i++){
            Matcher matcher = pattern.matcher(br.readLine());
            if(matcher.matches())
                bw.write("DA\n");
            else
                bw.write("NE\n");
            bw.flush();
        }
        bw.close();
    }
}