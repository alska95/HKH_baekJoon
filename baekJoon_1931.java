import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by kyeongha55@linecorp.com on 2024/01/10
 */
public class baekJoon_1931 {
    public static class Node {
        int startTime;
        int endTime;

        public Node(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int hashCode() {
            return startTime;
        }

        @Override
        public boolean equals(Object obj) {
            return startTime == ((Node) obj).startTime;
        }

        @Override
        public String toString() {
            return startTime + " " + endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Node> nodeList = new ArrayList<>();

        int roomNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < roomNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int starTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(starTime, endTime));
        }
        nodeList.sort((a, b) -> {
            if(a.endTime == b.endTime) {
                return a.startTime - b.startTime;
            } else {
                return a.endTime - b.endTime;
            }
        });
        int count = 0;
        int cur = 0;
        for(int i = 0 ; i < nodeList.size() ; i++) {
            if(nodeList.get(i).startTime >= cur) {
                cur = nodeList.get(i).endTime;
                count++;
            }
        }
        bw.write(count+"");

        bw.close();
    }
//
    //        keyList = timeMap.keySet().stream().sorted().collect(Collectors.toList());
//
//        Node firstNode = timeMap.get(keyList.get(0));
//        dfs(firstNode, 0, 0);
//        for( int i = 0; i < keyList.size() ; i++) {
//            if(firstNode.endTime > keyList.get(i)) {
//                Node betweenNode = timeMap.get(keyList.get(i));
//                dfs(betweenNode, i, 0);
//            }
//        }
//        bw.write(maxCount+"");

//    public static int maxCount = 0;
//
//    public static void dfs(Node node, int index, int count) {
//        int startIndex = index;
//        int startTime;
//        int newCount = count + node.repeat;
//        for( ; startIndex < keyList.size() ; startIndex++) {
//            if(node.endTime < keyList.get(startIndex)) {
//                startTime = keyList.get(startIndex);
//                Node newNode = timeMap.get(startTime);
//                dfs(newNode, startIndex, newCount);
//                for( ; startIndex < keyList.size() ; startIndex++) {
//                    if(newNode.endTime > keyList.get(startIndex)) {
//                        startTime = keyList.get(startIndex);
//                        Node betweenNode = timeMap.get(startTime);
//                        dfs(betweenNode, startIndex, newCount);
//                    } else {
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//        maxCount = Math.max(maxCount, newCount);
//    }
}
