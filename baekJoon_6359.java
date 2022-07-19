import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++) {
            int n = Integer.parseInt(br.readLine());
            boolean visited[] = new boolean[n+1];
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    int target = i*j;
                    if(target > n)
                        break;
                    visited[target] = !visited[target];
                }
            }
            int count = 0;
            for(int i = 1 ; i <= n ; i++){
                if(visited[i] == true)
                    count++;
            }
            bw.write(count+"\n");
        }
        bw.close();
    }
}
