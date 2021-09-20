import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target =br.readLine();
        Stack<Character> ans = new Stack<>();
        int result = 0;
        for(int i = 0 ; i < target.length() ; i++){
            if(target.charAt(i) == '(')
                ans.add('(');
            else{
                ans.pop();
                if(target.charAt(i-1) == '(')
                    result+=ans.size();
                else
                    result++;
            }
        }
        bw.write(result+"");
        bw.close();
    }
}