import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int [] segTree, board;
    public static int initTree(int start , int end , int node){
        if(start == end) return segTree[node]= board[start];
        int mid = (start + end) /2;

        return segTree[node] = Math.min(initTree(start, mid, node*2) , initTree(mid+1, end,node*2+1));
    }

    public static int solveTree(int start, int end, int node,int L , int R){ //구간 L~R
        if(L > end || R < start)
            return Integer.MAX_VALUE;
        if(L <= start && R >= end) return segTree[node];
        int mid = (start + end) /2;
        return Math.min(solveTree(start, mid, node*2 ,L, R) , solveTree(mid+1, end,node*2+1 ,L , R));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n+1];
        segTree = new int[4*(n+1)];
        for(int i = 1 ; i <= n ; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }
        initTree(1,n,1);
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            bw.write(solveTree(1,n,1,left, right) + "\n");
        }
        bw.close();
    }
}
