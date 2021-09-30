import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st =new StringTokenizer(br.readLine() , " ");
            String target = st.nextToken();
            pq.add(target);
        }
        while(!pq.isEmpty()){
            String cur = pq.poll();
            if(!pq.isEmpty()){
                if(pq.peek().equals(cur))
                    pq.poll();
                else
                    bw.write(cur + "\n");
            }else
                bw.write(cur);
        }
        bw.close();
    }
}