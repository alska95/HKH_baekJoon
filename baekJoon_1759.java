import java.io.*;
import java.util.*;

public class Main {
    static int visited[];
    static char board[];
    static ArrayList<String> result = new ArrayList<>();
    static void combination(int start, int n , int r){
        if(r == 0){
            int consonantCount = 0;
            int vowelCount = 0;
            String tmp = "";
            for(int i = 0 ; i < n ; i++){
                if(visited[i] == 1){
                    tmp+= board[i];
                    if(board[i] == 'a' || board[i] == 'i' || board[i] == 'o' ||
                            board[i] == 'e' || board[i] == 'u')
                        vowelCount++;
                    else
                        consonantCount++;
                }
            }
            if(vowelCount >= 1 && consonantCount >=2){
                char [] resultTmp = tmp.toCharArray();
                Arrays.sort(resultTmp);
                if(!result.contains(String.valueOf(resultTmp))){
                    result.add(String.valueOf(resultTmp));
                }
            }
        }
        for(int i = start ; i < n ; i++){
            visited[i] = 1;
            combination(i+1 , n , r-1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int C = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        board = new char[L];
        visited = new int[L];
        st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < L ; i++){
            board[i] = st.nextToken().toCharArray()[0];
        }
        combination(0 , L , C);
        Collections.sort(result);
        for (String s : result) {
            System.out.println(s);
        }
        bw.close();
    }
}
