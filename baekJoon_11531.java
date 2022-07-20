import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rightCount = 0;
        int score = 0;
        int[] penalty = new int[100];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            if(time == -1){
                break;
            }
            char q = st.nextToken().charAt(0);
            boolean right = st.nextToken().equals("right");
            if(right){
                score += penalty[q]*20 + time;
                rightCount++;
            }else{
                penalty[q]++;
            }
        }
        bw.write(rightCount+ " " + score);
        bw.close();
    }
}
