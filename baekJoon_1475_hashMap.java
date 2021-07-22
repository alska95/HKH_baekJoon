import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();

        HashMap<Integer , Integer> count = new HashMap<>(); //key , value
        for(int i = 0 ; i < 10 ; i++){
            count.put(i , 0);
        }
        for(int i = 0 ; i < n.length() ; i++){
            int target = Integer.parseInt(String.valueOf(n.charAt(i)));
            count.put(target ,count.get(target)+1);
        }
        int sum = (int) Math.ceil((count.get(6) + count.get(9))/2F);
        count.put(6 , sum);
        count.put(9 , sum);
        int max = 0;
        for (Integer integer : count.values()) {
            if(max < integer){
                max = integer;
            }
        }
        bw.write(max+"");
        bw.close();
    }
}