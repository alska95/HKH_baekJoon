import java.io.*;;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2)->o2-o1);
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int target = Integer.parseInt(br.readLine());
            if(maxPQ.size() == minPQ.size())
                maxPQ.add(target);
            else
                minPQ.add(target);
            if(!maxPQ.isEmpty() && !minPQ.isEmpty()){
                if(minPQ.peek() < maxPQ.peek()){
                    int tmp = minPQ.poll();
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(tmp);
                }
            }
            bw.write(maxPQ.peek()+"\n");
        }
        bw.close();
    }
}
