import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            char visited [] = new char[100];
            String target = br.readLine();
            int result = 0;
            for(int j = 0 ; j < target.length(); j++){
                char tc = target.charAt(j);
                if(visited[tc] == 0) {
                    visited[tc] = 1;
                    result++;
                }
                if(result == 10)
                    break;
            }
            bw.write(result+"\n");
        }
        bw.close();
    }

}
