package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//하얀 칸일 조건 0,0 이 흰색 %2 0 이면 %20
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for(int i = 0 ; i < 8 ; i++){
            String target = br.readLine();
            for(int j = 0 ; j < 8 ; j++){
                if(i % 2 == 0){
                    if(j %2 == 0 && target.charAt(j) == 'F'){
                        count++;
                    }
                }else{
                    if(j %2 == 1 && target.charAt(j) == 'F'){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
