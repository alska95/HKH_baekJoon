package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    static Pos biber;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int[][] dist = new int[n][m];
        int[] tx = {1, -1, 0, 0};
        int[] ty = {0, 0, 1, -1};
        Queue<Pos> waterQ = new LinkedList<>();
        Queue<Pos> hedgehogQ = new LinkedList<>();


        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'D') biber = new Pos(i, j);
                else if(map[i][j] == 'S') hedgehogQ.add(new Pos(i, j));
                else if(map[i][j] == '*') waterQ.add(new Pos(i, j));
            }
        }

        while(!hedgehogQ.isEmpty()) {
            int size = waterQ.size();
            while(size-- > 0) {
                Pos k = waterQ.poll();
                for(int i=0; i<4; i++) {
                    if(k.x+tx[i]>=0 && k.x+tx[i]<n && k.y+ty[i]>=0 && k.y+ty[i]<m) {
                        if(map[k.x+tx[i]][k.y+ty[i]] == '.' || map[k.x+tx[i]][k.y+ty[i]] == 'S') {
                            map[k.x+tx[i]][k.y+ty[i]] = '*';
                            waterQ.add(new Pos(k.x+tx[i], k.y+ty[i]));
                        }
                    }
                }
            }
            size = hedgehogQ.size();
            while(size-- > 0) {
                Pos k = hedgehogQ.poll();
                for(int i=0; i<4; i++) {
                    if(k.x+tx[i]>=0 && k.x+tx[i]<n && k.y+ty[i]>=0 && k.y+ty[i]<m) {
                        if(map[k.x+tx[i]][k.y+ty[i]] != 'X' && map[k.x+tx[i]][k.y+ty[i]] != '*') {
                            if(dist[k.x+tx[i]][k.y+ty[i]] == 0) {
                                dist[k.x+tx[i]][k.y+ty[i]] = dist[k.x][k.y]+1;
                                hedgehogQ.add(new Pos(k.x+tx[i], k.y+ty[i]));
                            }
                        }
                    }
                }
            }
        }
        String ans = (dist[biber.x][biber.y] == 0) ? "KAKTUS" : String.valueOf(dist[biber.x][biber.y]) ;
        System.out.println(ans);
    }
}
class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
