import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int z1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int z2 = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            x1 = Math.max(Integer.parseInt(st.nextToken()),x1);
            y1 = Math.max(Integer.parseInt(st.nextToken()),y1);
            z1 = Math.max(Integer.parseInt(st.nextToken()),z1);
            x2 = Math.min(Integer.parseInt(st.nextToken()),x2);
            y2 = Math.min(Integer.parseInt(st.nextToken()),y2);
            z2 = Math.min(Integer.parseInt(st.nextToken()),z2);

        }

        int result = (x2-x1)*(y2-y1)*(z2-z1);

        result = result < 0 ? 0 : result;
        
        bw.write(result+"");
        bw.close();
    }
}