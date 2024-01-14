import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int rev(int target) {
        String tmp = String.valueOf(target);
        StringBuilder sb = new StringBuilder();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            sb.append(tmp.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(rev(rev(x) + rev(y)) + "");
        bw.close();
    }
}
