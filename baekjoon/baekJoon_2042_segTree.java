package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Long initTree(int start , int end , int node){
        if(start == end) return segTree[node] = board[start];
        int mid = (start + end) / 2;
        return segTree[node] = initTree(start, mid , node*2) +  initTree(mid+1 , end , node*2+1);
    }
    static Long solveTree(int start, int end , int node, int left ,long right){
        if(start>right || left > end) return 0L;
        if(left <= start && end <= right) return segTree[node];
        int mid = (start+end)/2;
        return solveTree(start , mid , node*2 , left , right) + solveTree(mid+1 , end , node*2+1  , left ,right);
    }
    static void updateTree(int start , int end, int node,int index, long diff){
        if(start > index || end < index) return;
        segTree[node] +=diff;
        if(start == end) return;
        int mid = (start+end)/2;
        updateTree(start , mid , node*2, index , diff);
        updateTree(mid+1 , end , node*2+1, index , diff);
    }
    static long board [] , segTree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new long[n+1];
        segTree = new long[4*n +1];

        for(int i = 1 ; i<= n ; i++){
            board[i] = Long.parseLong(br.readLine());
        }
        initTree(1,n,1);
        for(int i = 0 ; i < m+k ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                long diff =  (c - board[b]);
                board[b] = c;
                updateTree(1,n,1,b,diff);
            }else{
                bw.write(solveTree(1,n,1,b,c)+"\n");
            }
        }

        bw.close();
    }
}
