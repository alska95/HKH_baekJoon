import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String tc = st.nextToken();
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                if(tc.equals("C")){
                    bw.write((int) st.nextToken().charAt(0) - 64 +" ");
                }else{
                    bw.write((char) (Integer.parseInt(st.nextToken())+64) + " ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}
