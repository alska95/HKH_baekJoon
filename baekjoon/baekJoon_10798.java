package baekjoon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target[] = new String[5];

        for(int i = 0 ; i < 5 ; i++){
            target[i] = br.readLine();
        }
        String sequence[] = new String[15];
        for(int i = 0 ; i < 15 ; i++){
            sequence[i] = "";
            for(int j = 0 ; j < 5 ; j++){
                if(target[j].length() > i){
                    sequence[i] += target[j].charAt(i);
                }
            }
        }
        for (String s : sequence) {
            if(s == null)
                break;
            bw.write(s);
        }
        bw.close();
    }
}
