package baekjoon;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine() , " ");
        List<Integer> ls = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i++){
            ls.add(Integer.parseInt(st.nextToken()));
        }
        ls.sort(Comparator.comparingInt(o -> o));
        bw.write(Math.abs(ls.get(1)+ls.get(2)-ls.get(3)-ls.get(0))+"");
        bw.close();
    }
}
