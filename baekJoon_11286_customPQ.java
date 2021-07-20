import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)== Math.abs(o2)){
                    return o1-o2;
                }
                return Math.abs(o1)- Math.abs(o2);
            }
        });

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0){
                pq.add(tmp);
            }else{
                if(pq.isEmpty()){
                    bw.write(0+"\n");
                }else{
                    bw.write(pq.poll() + "\n");
                }
            }
        }
        bw.close();
    }
}