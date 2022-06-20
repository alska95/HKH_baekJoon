import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int flag = 0;
        for(int i = target.length()-1 ; i >= 0; i--){
            cur += target.charAt(i)-48;
            if(flag == 1){
                sb.insert(0,"7");
            } else if(cur >= 7){
                sb.insert(0,"7");
                cur = (cur - 7) *10;
            }else if(cur >= 4){
                sb.insert(0,"4");
                cur = (cur - 4) *10;
            }else{
                flag =1;
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
