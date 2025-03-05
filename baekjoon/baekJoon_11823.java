package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static int s;
    static int visited[] = new int [50];
    static int count = 0;
    public static void combination(int start, int r , int [] array){
        if(r == 0){
            int result =  0;
            for(int i = 0 ; i < n ; i++){
                if(visited[i] == 1){
                    result+=array[i];
                }
            }

            if(result == s)
                count++;
        }
        for(int i = start ; i < n ; i++){
            visited[i] = 1;
            combination(i+1, r-1 , array);
            visited[i] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() ,  " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int array []= new int[n];

        st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i<=n ;i++){
            combination(0,i,array);
        }

        bw.write(count+"");
        bw.close();

    }
}
