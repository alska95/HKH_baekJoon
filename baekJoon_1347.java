import java.io.*;
import java.util.*;

public class Main {
    static int x;
    static int y;
    static int direction;
    public static void makeMove( ){
        switch (direction){
            case 0:
                y--;
                break;
            case 1:
                x++;
                break;
            case 2:
                y++;
                break;
            case 3:
                x--;
                break;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int visited [][]= new int[101][101];
        x = 50;
        y = 50;
        direction = 0;

        int n = Integer.parseInt(br.readLine());
        String moves = br.readLine();

        int startX = 50;
        int endX = 50;
        int startY = 50;
        int endY = 50;


        visited[y][x] = 1;

        for(int i = 0 ; i < n ; i++){
            switch (moves.charAt(i)){
                case 'L':
                    if(direction<3){
                        direction++;
                    }else{
                        direction = 0;
                    }
                    break;
                case 'R':
                    if(direction>0){
                        direction--;
                    }else{
                        direction = 3;
                    }
                    break;
                case 'F':
                    makeMove();
                    break;

            }
            visited[y][x] = 1;
            startX = Math.min(x,startX);
            startY = Math.min(y,startY);
            endX = Math.max(x,endX);
            endY = Math.max(y,endY);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = endY ; i >= startY ; i--){
            for(int j = startX ; j <= endX ; j++){
                if(visited[i][j] == 1){
                    sb.append(".");
                }else{
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        bw.close();
    }
}