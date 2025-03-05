package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 40000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] p = new int[MAX];
        Vector<Integer> c = new Vector<Integer>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        c.add(p[0]);

        for (int i = 1; i < N; i++) {
            if (p[i] > c.lastElement()) {
                c.add(p[i]);
            } else {
                int j = 0;
                for (j = 0; j < c.size(); j++) { // p[i]보다 처음으로 같거나 큰 수 찾기
                    if (p[i] > c.get(j))
                        continue;
                    else
                        break;
                }
                c.remove(j);
                c.add(j, p[i]);
            }
        }
        bw.write(Integer.toString(c.size()));
        bw.close();
    }

}
