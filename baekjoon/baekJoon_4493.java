package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            int round = Integer.parseInt(br.readLine());

            int aCount = 0;
            int bCount = 0;
            for(int j = 0 ; j < round ; j++){
                StringTokenizer st = new StringTokenizer(br.readLine() , " ");

                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);
                switch (a){
                    case 'R':
                        switch (b){
                            case 'R':
                                break;
                            case 'P':
                                bCount++;
                                break;
                            case 'S':
                                aCount++;
                                break;
                        }
                        break;
                    case 'P':
                        switch (b){
                            case 'P':
                                break;
                            case 'S':
                                bCount++;
                                break;
                            case 'R':
                                aCount++;
                                break;
                        }
                        break;
                    case 'S':
                        switch (b){
                            case 'S':
                                break;
                            case 'R':
                                bCount++;
                                break;
                            case 'P':
                                aCount++;
                                break;
                        }
                        break;
                }
            }
            if(aCount == bCount)
                bw.write("TIE\n");
            else
                bw.write(aCount > bCount ? "Player 1\n":"Player 2\n");
        }
        
        bw.close();
    }
}
