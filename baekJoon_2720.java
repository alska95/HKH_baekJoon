import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        int coins [] = {25,10,5,1};
        for(int i = 0 ; i < testCase ; i++){
            int target  =  Integer.parseInt(br.readLine());
            for(int j = 0 ; j < 4 ; j++){
                bw.write(target/coins[j]+" ");
                target %= coins[j];
            }
            bw.write("\n");
        }
        bw.close();
    }
}