import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        if(target<=2){
            bw.write("NEWBIE!");
        }else if(target<=n){
            bw.write("OLDBIE!");
        }else{
            bw.write("TLE!");
        }

        bw.close();
    }
}