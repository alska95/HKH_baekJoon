import java.io.*;
import java.util.*;

public class Main {

    public static class Pair {
        int cord;
        String target;

        Pair(int cord, String target){
            this.cord = cord;
            this.target = target;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            List<Pair> pairList = new ArrayList<>();
            List<Pair> copyList = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                Pair p = new Pair(i, br.readLine());
                pairList.add(p);
                copyList.add(p);
            }
            pairList.stream()
                    .sorted(Comparator.comparing(p -> p.target.toLowerCase(Locale.ROOT)))
                    .findFirst()
                    .ifPresent(p-> {
                        try {
                            bw.write(copyList.get(p.cord).target+"\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        bw.close();
    }
}
