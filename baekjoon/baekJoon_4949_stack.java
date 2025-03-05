package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        String target = "";
        while((target = br.readLine()) != null){
            s.clear();
            if(target.equals("."))
                break;
            for(int i = 0 ; i < target.length() ;i++){
                char tmp = target.charAt(i);
                if(tmp == '(' || tmp =='['){
                    s.push(tmp);
                }else if(tmp == ')' || tmp == ']') {
                    if(s.isEmpty() || (tmp == ')' && s.peek() != '(') || (tmp == ']' && s.peek() != '[')) {
                        s.push(tmp);
                        break;
                    }
                    s.pop();
                }
            }
            if(s.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
