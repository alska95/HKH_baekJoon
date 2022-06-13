import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int count = 1;
        for(int i = 0 ; i < n ;i++){
            if(target.charAt(i) == 'L'){
                i++;
            }
            count++;
        }
        bw.write(Math.min(n,count)+"");
        bw.close();
    }
}
