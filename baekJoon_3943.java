import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int z = 0; z < n; z++) {
            long target =Long.parseLong(br.readLine());
            long max = target;
            while(target != 1){
                if(target % 2 == 0){
                    target /= 2;
                }else{
                    target = target*3+1;
                }
                max = Math.max(target, max);

            }
            bw.write(max+"\n");
        }
        bw.close();
    }
}
