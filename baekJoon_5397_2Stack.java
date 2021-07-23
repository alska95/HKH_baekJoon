import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int tc=0; tc<testCases; tc++) {
            Stack<Character> st1 = new Stack<>();
            Stack<Character> st2 = new Stack<>();

            String str = br.readLine();
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i)=='<') {
                    if(!st1.isEmpty())
                        st2.push(st1.pop());
                }else if(str.charAt(i)=='>') {
                    if(!st2.isEmpty())
                        st1.push(st2.pop());
                }else if(str.charAt(i)=='-') {
                    if(!st1.isEmpty())
                        st1.pop();
                }else {
                    st1.push(str.charAt(i));
                }
            }

            while(!st2.isEmpty())
                st1.push(st2.pop());

            StringBuilder sb = new StringBuilder();
            while(!st1.isEmpty())
                sb.append(st1.pop());
            System.out.println(sb.reverse());
        }
    }
}
