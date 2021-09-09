
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> lotto;
    static int[] visited;
    public static void combination(int start,int n , int r){
        if(r == 0){
            for(int i = 0 ; i < n ; i++){
                if(visited[i] == 1){
                    System.out.printf(lotto.get(i)+ " ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = start ; i < n ; i++){
            visited[i] = 1;
            combination(i+1, n , r-1);
            visited[i] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = "";
        while(!target.equals("0")){
            target = br.readLine();
            if(target.equals("0"))
                break;
            lotto = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(target , " ");
            int n = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                lotto.add(Integer.parseInt(st.nextToken()));
                if(!st.hasMoreTokens())
                    break;
            }
            visited = new int[lotto.size()];
            combination(0,lotto.size() , 6);
            System.out.println();
        }

        bw.close();
    }
}
