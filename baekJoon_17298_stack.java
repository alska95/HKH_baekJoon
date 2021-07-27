import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int [] targets = new int[n];
        int [] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty()){
                int nextS = s.peek();
                if(targets[i] < nextS){
                    result[i] = nextS;
                    break;
                }else{
                    s.pop();
                }
            }
            if(s.isEmpty())
                result[i] = -1;
            s.push(targets[i]);
        }
        for (int i : result) {
            bw.write(i+" ");
        }
        bw.close();
    }
}
