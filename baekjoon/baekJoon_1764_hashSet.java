package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> a = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            a.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            String tmp = br.readLine();
            if(a.contains(tmp)){
                result.add(tmp);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(String i : result){
            System.out.println(i);
        }
    }
}
