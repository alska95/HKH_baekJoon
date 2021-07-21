import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<int []> tower = new Stack<>(); //{index , value}
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int [] result = new int[n];
        for(int i = 0 ; i < n ; i++){
            int next = Integer.parseInt(st.nextToken());
            while(!tower.isEmpty()){
                if(tower.peek()[1] > next){
                    result[i] = tower.peek()[0]+1;
                    break;
                }else{
                    tower.pop();
                }
            }
            tower.push(new int[]{i , next});
        }
        for (int i : result) {
            bw.write(i+" ");
        }
        bw.close();
    }
}
