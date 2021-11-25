import java.io.*;
import java.util.*;

public class Main {

    public static class Jewel{
        int cost;
        int weight;

        public Jewel(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();
        ArrayList<Integer> bags = new ArrayList<>();

        for(int i = 0 ; i < n ; i ++){
            st= new StringTokenizer(br.readLine() , " ");
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(cost, weight));
        }

        for(int i = 0 ; i < k ; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if(o1.weight == o2.weight){
                    return o2.cost-o1.cost;
                }else
                return o1.weight - o2.weight;
            }
        });

        Collections.sort(bags);


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2- o1;
            }
        });

        long result = 0;

        for(int i = 0, j = 0 ; i < k; i++){
            for( ; j < n ; j++){
                if(jewels.get(j).weight <= bags.get(i)){
                    pq.add(jewels.get(j).cost);
                }else{
                    break;
                }
            }

            if(!pq.isEmpty()){
                result+=pq.poll();
            }
        }

        bw.write(result+"");
        bw.close();
    }
}