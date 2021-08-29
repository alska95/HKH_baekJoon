import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] pieces = {1,2,4,8,16,32,64};
        int target = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 6 ; i >=0 ; i--){
            if(target >= pieces[i]){
                count++;
                target-=pieces[i];
                if(target == 0)
                    break;
            }
        }
        bw.write(count+"");
        bw.close();
    }
}
