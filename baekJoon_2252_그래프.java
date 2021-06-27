import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexNum = sc.nextInt();
        int nodeNum = sc.nextInt();

        ArrayList<ArrayList<Integer>> status = new ArrayList<>();
        int [] indeg = new int[vertexNum+1];

        for(int i = 0 ; i < vertexNum+1 ; i++){
            status.add(new ArrayList<>());
        }

        for(int i =0  ; i< nodeNum ; i++){
            int taller = sc.nextInt();
            int smaller = sc.nextInt();
            status.get(taller).add(smaller);
            indeg[smaller]++;
        }


        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int i = 1 ; i <vertexNum+1 ; i++){
            if(indeg[i] == 0){
                bfsQueue.add(i);
            }
        }
        while(!bfsQueue.isEmpty()){
            int current = bfsQueue.poll();
            System.out.println(current);

            for(int i = 0 ; i < status.get(current).size() ; i++){
                int next = status.get(current).get(i);
                indeg[next]--;
                if(indeg[next] == 0){
                    bfsQueue.add(next);
                }
            }
        }
    }
}