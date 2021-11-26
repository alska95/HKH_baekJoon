
import java.io.*;
import java.util.*;


/**
 *
 *  숫자가 이전꺼보다 크면 바로 집어넣음.
 *  아니면 이진탐색을 이용해서 갱신해준다. --> 목록은 틀릴 수 있지만 최대길이는 유지된다.
* */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int board[] = new int[n];
//        int dp[] = new int[n];
        int highNums[] = new int[n]; //index는 board의 크기이고 거기에 가장 큰 dp값이 저장된다.
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) { // i가 target으로 연결됨
            board[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < board[i]){
                dp.add(board[i]);
            }else{ //멈추게 되는곳, 나보다 큰애 중 제일 작은애 1 3 5 6   4가 들어옴 l1 r4 m2 l3 r4 m3 l3 r3
                int left = 0;
                int right = dp.size()-1;
                while(left<=right){
                    int mid = (left + right)/2;
                    if(dp.get(mid) <= board[i]){ //같을때도 증가시켜서 다음수의 자리 사용
                        left = mid+1;
                    }else{
                        right = mid -1;
                    }
                }

                dp.set(right+1 , board[i]);
            }
            max = dp.get(dp.size()-1);
//            for (Integer integer : dp) {
//                System.out.printf(integer + " ");
//            }
//            System.out.println();
        }
        // 2 3 4 1 2 3 4 5


        bw.write(n - dp.size() + "");
        bw.close();
    }
}