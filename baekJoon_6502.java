import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int iter = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            if(r == 0){
                break;
            }
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(Math.sqrt(Math.pow(w,2)+Math.pow(l,2))/2 <= r){
                bw.write("Pizza "+iter+" fits on the table.\n");
            }else{
                bw.write("Pizza "+iter+" does not fit on the table.\n");
            }
            iter++;
        }
        bw.close();
    }
}
