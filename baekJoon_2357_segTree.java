
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int board[];
    static int segMinTree[];
    static int segMaxTree[];
    public static int initMinTree(int start , int end , int node){
        if(start == end) return segMinTree[node] = board[start];
        int mid = (start + end )/2;
        return segMinTree[node] =
                Math.min(initMinTree(start , mid , node*2) , initMinTree(mid+1, end , node*2 +1));
    }
    public static int initMaxTree(int start , int end , int node){
        if(start == end) return segMaxTree[node] = board[start];
        int mid = (start + end )/2;
        return segMaxTree[node] =
                Math.max(initMaxTree(start , mid , node*2) , initMaxTree(mid+1, end , node*2 +1));
    }
    public static int solveMinTree(int start , int end , int node , int left , int right){
        if(start > right || end < left) return Integer.MAX_VALUE;
        if(left <= start && end <= right) return segMinTree[node];
        int mid = (start + end)/2;
        return Math.min(solveMinTree(start , mid , node*2 , left ,right) , solveMinTree(mid+1 , end , node*2 +1 , left , right));
    }

    public static int solveMaxTree(int start , int end , int node , int left , int right){
        if(start > right || end < left) return 0;
        if(left <= start && end <= right) return segMaxTree[node];
        int mid = (start + end)/2;
        return Math.max(solveMaxTree(start , mid , node*2 , left ,right) , solveMaxTree(mid+1 , end , node*2 +1 , left , right));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n+1];
        segMinTree = new int[4*n +1];
        segMaxTree = new int[4*n +1];
        for(int i = 1 ; i <= n ; i ++){
            board[i] = Integer.parseInt(br.readLine());
        }
        initMinTree(1,n,1);
        initMaxTree(1,n,1);
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            bw.write(solveMinTree(1,n,1 , left , right) +" " + solveMaxTree(1,n,1,left,right) + "\n");
        }

        bw.close();
    }
}
