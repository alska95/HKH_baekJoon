import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int savedCost() {
            return end - start - cost;
        }
    }

    public static List<Node> nodeList = new ArrayList<>();

    public static int finalCost;
    public static int[] visited;
    public static int distance;

    public static void progressCombination(int index, int progress, int savedCost) {
        if (nodeList.stream().noneMatch(node -> node.start >= progress)) {
            finalCost = Math.min(finalCost, distance - savedCost);
        }

        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).start >= progress) {
                progressCombination(index + 1, nodeList.get(i).end, savedCost + nodeList.get(i).savedCost());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        finalCost = distance;

        visited = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (end - start > cost && end <= distance) {
                nodeList.add(new Node(start, end, cost));
            }
        }

        progressCombination(0, 0, 0);
        bw.write(finalCost + "");
        bw.close();
    }
}
