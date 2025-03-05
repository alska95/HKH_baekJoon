package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static class Status{
        int gen;
        int loc;

        public Status(int gen, int loc) {
            this.gen = gen;
            this.loc = loc;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Status> board = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int gen = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            board.add(new Status(gen,loc));
        }
        Collections.sort(board, new Comparator<Status>() {
            @Override
            public int compare(Status o1, Status o2) {
                return o1.loc-o2.loc;
            }
        });
        int dp[][] = new int[n+1][2];
        for(int i = 1 ; i <= n ; i++){
            int cur = board.get(i-1).gen;
            dp[i][cur] = dp[i-1][cur]+1;
            if(cur == 0){
                dp[i][1] = dp[i-1][1];
            }else{
                dp[i][0] = dp[i-1][0];
            }

        }
//        for(int i = 1 ; i <= n ; i++){
//            System.out.println(dp[i][0] + " " + dp[i][1] +" loc: "+ board.get(i-1).loc + " gendp : " + (dp[i][0] - dp[i][1]) + " 성별 : " +board.get(i-1).gen);
//        } // dp의 차가 똑같으면, 시작점 다음index부터 끝점까지가 유효범위이다.

        int genDp[] = new int[n+1];
        for(int i = 0 ; i<= n ; i++){
            genDp[i] = Math.abs(dp[i][0] - dp[i][1]);
//            System.out.println(genDp[i]);
        }
        int startEndDp[][] = new int[n+1][2];
        for(int i = 0 ; i <= n ; i++){
            startEndDp[i][0] = -1;
            startEndDp[i][1] = -1;
        }
        for(int i = 0; i <= n ; i++){
//            System.out.println("gendp = " + genDp[i]);
            if(startEndDp[genDp[i]][0] == -1){
//                System.out.println("yes");
                if(i == 0)
                    startEndDp[genDp[i]][0] = 0;
                else
                startEndDp[genDp[i]][0] = i-1;
            }else{
                startEndDp[genDp[i]][1] = i-1;
            }
        }
//        for (int[] ints : startEndDp) {
//            System.out.println("sed"+ints[0] +" " + ints[1]);
//        }
        int result = 0;
        for(int i = 0 ; i <= n ; i++){
            if(startEndDp[i][0] != -1 && startEndDp[i][1] != -1){
//                System.out.println("성립했다 : " +board.get(startEndDp[i][0]+1).loc + " 끝점 : "+board.get(startEndDp[i][1]).loc +
//                        " 결과 : " + (board.get(startEndDp[i][1]).loc-board.get(startEndDp[i][0]+1).loc));
                if(startEndDp[i][0] == 0)
                    result = Math.max(result, board.get(startEndDp[i][1]).loc-board.get(startEndDp[i][0]).loc);
                else
                result = Math.max(result, board.get(startEndDp[i][1]).loc-board.get(startEndDp[i][0]+1).loc);
            }
        }
        bw.write(result+"");
        //dp를 사용해서 만족하는 시작점중 제일 긴 애를 넣는다. 만족하면 0임.
        bw.close();
    }
}
