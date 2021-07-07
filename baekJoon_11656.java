import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1 ; i < target.length() ; i++){
            result.add(target.substring(target.length()-i));
        }
        result.sort(Comparator.naturalOrder());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
