package baekjoon;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException, ScriptException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        Stack<Character> s = new Stack<>();
        String resultString = "";
        double result =1;
        for(int i = 0 ; i < target.length() ; i++){
            char next = target.charAt(i);
            if(next == '('){
                s.push(')');
            }else if(next == '['){
                s.push(']');
            }else if(next == ')'){
                if(s.isEmpty()){
                    result = 0;
                    break;
                }
                if(s.pop()!= next){
                    result = 0;
                    break;
                }
            }else if(next == ']'){
                if(s.isEmpty()){
                    result = 0;
                    break;
                }
                if(s.pop()!= next){
                    result = 0;
                    break;
                }
            }
        }
        if(!s.isEmpty()){
            result= 0;
        }
        if(result == 1) {
            for (int i = 0; i < target.length(); i++) {
                char next = target.charAt(i);
                if (next == '(') {
                    if (target.charAt(i + 1) == ')') {
                        resultString += "2+";
                    } else {
                        resultString += "2*(";
                    }
                } else if (next == '[') {
                    if (target.charAt(i + 1) == ']') {
                        resultString += "3+";
                    } else {
                        resultString += "3*(";
                    }
                } else if (next == ')') {
                    if (target.charAt(i - 1) != '(')
                        resultString += ")";
                } else if (next == ']'){
                    if (target.charAt(i - 1) != '[')
                        resultString += ")";
                }
            }
            System.out.println(resultString);
            resultString = resultString
                    .replaceAll("\\)2",")+2")
                    .replaceAll("\\)3",")+3")
                    .replaceAll("\\+\\)" , ")")
                    .replaceAll("[^)]$" , "");

            System.out.println(resultString);
            ScriptEngineManager se = new ScriptEngineManager();
            ScriptEngine engine = se.getEngineByName("JavaScript");
            try{
                result = (double) engine.eval(resultString);
            }catch (Exception e){
                System.out.println(e);
                result = 0;
            }
        }

        System.out.println((long)result);

    }
}
