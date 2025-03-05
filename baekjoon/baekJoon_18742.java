package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 숫자를 꺼내려면 적어도 그 숫자만큼 push해야한다.
 * 첫번재 숫자만큼 push.
 * 만약 다음 숫자가 더 작다면 , 작은 숫자는 1씩 내림차순으로 나와야함.
 * 만약 다음 숫자가 더 크다면 , 큰 수만큼 push (큰수는 max로 측정하기)
 * 만약 push가 n만큼 이뤄졌다면 , pop만 가능.
 * 각각의 수행 결과(integer)를 container에 저장
 * 각각 pop수행 , push 수행시 , - , + 를 result Queue에 저장
 * container와 target이 같으면 result 출력
 * 다르면 no
 *
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] target = new int[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            target[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> tmp = new Stack<>();
        Queue<Integer> container = new LinkedList<>();
        Queue<String> result = new LinkedList<>();
        int Iterator = 1;
        int prev = 0;
        for(int i = 1 ; i <= n ; i++){
            if(Iterator <= n){
                if(target[i] > prev){
                    prev = target[i];
                    for(; Iterator <= target[i]  ;Iterator++){
//                        System.out.println("+");
                        result.add("+");

                        tmp.push(Iterator);
                    }
//                    System.out.println("-");
                    result.add("-");
                    container.add(tmp.pop());
                }else{
//                    System.out.println("-");
                    result.add("-");
                    prev = tmp.pop();
                    container.add(prev);
                }
            }else{
                container.add(tmp.pop());
                result.add("-");
//                System.out.println("-");
            }
        }
        int flag = 0;
        for(int i = 1 ; i < n+1 ; i++){
            if(container.poll() != target[i]){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            System.out.println("NO");
        }else{
            for(String i : result){
                System.out.println(i);
            }
        }
    }
}

