
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int board[];
    static int minSegTree[];
    static int maxSegTree[];

    public static int initMinSegTree(int start, int end, int node){
        if(start == end) return minSegTree[node] = board[start];
        int mid = (start+end)/2;
        return minSegTree[node] = Math.min(initMinSegTree(start , mid , node*2),
                initMinSegTree(mid+1, end , node*2+1));
    }
    public static int initMaxSegTree(int start, int end, int node){
        if(start == end) return maxSegTree[node] = board[start];
        int mid = (start+end)/2;
        return maxSegTree[node] = Math.max(initMaxSegTree(start , mid , node*2),
                initMaxSegTree(mid+1, end , node*2+1));
    }

    public static int findMaxSegTree(int left, int right , int start , int end ,int node){
        if(start > right || end < left) return Integer.MIN_VALUE;
        if(start >=left && end <= right) return maxSegTree[node];
        int mid = (start+end)/2;
        return Math.max(findMaxSegTree(left, right, start, mid,node*2),
                findMaxSegTree(left,right,mid+1, end,node*2+1));
    }

    public static int findMinSegTree(int left, int right , int start , int end ,int node){
        if(start > right || end < left) return Integer.MAX_VALUE;
        if(start >=left && end <= right) return minSegTree[node];
        int mid = (start+end)/2;
        return Math.min(findMinSegTree(left, right, start, mid,node*2),
                findMinSegTree(left,right,mid+1, end,node*2+1));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            board[i] = Integer.parseInt(br.readLine());
        }
        minSegTree = new int[4*n+1];
        maxSegTree = new int[4*n+1];
        initMinSegTree(1,n,1);
        initMaxSegTree(1,n,1);
/*        for(int i = 0 ; i <= n ; i++){
            System.out.println("minSegTree = " + minSegTree[i]);
        }
        for(int i = 0 ; i <= n ; i++){
            System.out.println("maxSegTree = " + maxSegTree[i]);
        }*/
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int minResult = findMinSegTree(left, right, 1, n, 1);
            int maxResult = findMaxSegTree(left, right, 1, n, 1);
            bw.write(minResult+" "+maxResult+"\n");
        }
        bw.close();
    }
}