import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                bw.write("*");
            }
            for(int j = (n-i)*2 ; j > 0 ; j--){
                bw.write(" ");
            }
            for(int j = 0 ; j < i ; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        for(int i = 0 ; i < n*2 ; i++){
            bw.write("*");
        }
        bw.write("\n");
        for(int i = n ; i>0 ; i--){
            for(int j = i ; j >1 ; j--){
                bw.write("*");
            }
            for(int j = 0 ; j < (n-i+1)*2 ; j++){
                bw.write(" ");
            }
            for(int j = i ; j >1 ; j--){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
