package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node board [] = new Node[8];
        for(int i = 0 ; i < 8 ; i++){
            board[i] = new Node(Integer.parseInt(br.readLine()) ,i);
        }
        ArrayList<Integer> resultSet = new ArrayList<>();

        Arrays.sort(board, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val;
            }
        });
        int sum =0;
        int result[] = new int[5];
        for(int i = 0 ; i < 5 ; i++){
            sum+= board[i].val;
            result[i] = board[i].index;
        }

        Arrays.sort(result);

        bw.write(sum+"\n");
        for (int i : result) {
            bw.write(i+1+" ");
        }
        bw.close();
    }
}
