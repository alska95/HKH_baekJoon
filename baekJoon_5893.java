import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int board1[] = new int[target.length()+5];
        int board2[] = new int[target.length()+5];

        for(int i = 5 ; i < target.length()+5 ; i++){
            board1[i] = Integer.parseInt(String.valueOf(target.charAt(i-5)));
        }

        for(int i = 1 ; i < target.length()+1; i++){
            board2[i] = Integer.parseInt(String.valueOf(target.charAt(i-1)));
        }
        int result[] = new int[target.length()+6];

        for(int i = target.length()+4 ; i >= 0 ; i--){
            int key = result[i] + board1[i] + board2[i];

            if(key == 1){
                result[i] = 1;
            }else if(key == 2){
                result[i-1] = 1;
                result[i] = 0;
            }else if(key == 3){
                result[i-1] = 1;
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }
        if(result[0] == 1){
            bw.write(result[0]+"");
        }
        for(int i = 1 ; i < result.length-1 ; i++){
            bw.write(result[i]+"");
        }
        bw.close();
    }
}