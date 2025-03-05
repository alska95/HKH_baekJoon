package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [] target = br.readLine().toCharArray();
        for(int i = 0 ; i < n-1 ; i++){
            char [] next = br.readLine().toCharArray();
            for(int j = 0 ; j < next.length ; j++){
                if(target[j] != next[j]){
                    target[j] = '?';
                }
            }
        }
        System.out.println(target);
    }
}
