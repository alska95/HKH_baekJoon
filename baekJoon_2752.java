import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int targets[] = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < 3 ; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(targets);
        for (int target : targets) {
            bw.write(target + " ");
        }
        bw.close();
    }
}
