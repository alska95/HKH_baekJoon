import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> solveQueue = new LinkedList<>();
        for(int i = 1 ; i < n+1 ; i++){
            solveQueue.add(i);
        }
        System.out.printf("<");
        while(solveQueue.size() != 1){
            for(int i = 0 ; i < k-1 ; i++){
                solveQueue.add(solveQueue.poll());
            }
            System.out.print(solveQueue.poll() + ", ");
        }
        System.out.printf(solveQueue.poll() + ">");
    }
}
