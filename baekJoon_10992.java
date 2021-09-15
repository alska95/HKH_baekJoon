import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        for(int j = 0 ; j < target ; j++){
            if(j == target -1){
                for(int i = 1 ; i < target*2; i++){
                    bw.write("*");
                }
            }else{
                for(int i = 1 ; i <= target; i++){
                    if(i == target - j){
                        bw.write("*");
                    }else
                    {
                        bw.write(" ");
                    }
                }
                for(int i = target ; i <= target*2; i++){
                    if(j == 0)
                        break;
                    if(i == target + j-1){
                        bw.write("*");
                        break;
                    }else
                    {
                        bw.write(" ");
                    }
                }
            }

            bw.write("\n");
        }

        bw.close();
    }
}