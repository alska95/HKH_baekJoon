package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i ++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            if(pq.isEmpty())
                break;
            int second = pq.poll();
            int tmp = first + second;
            result+= tmp;
            pq.add(tmp);
        }


        bw.write(result +"");
        bw.close();
    }
}
