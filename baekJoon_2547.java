import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int z= 0 ; z < t ; z++){
            br.readLine();
            BigInteger target = new BigInteger(br.readLine());
            BigInteger result = new BigInteger("0");
            for(int i = 0 ; i < target.longValue() ; i++){
                BigInteger cur = new BigInteger(br.readLine());
                result = result.add(cur).remainder(target);
            }
            if(result.equals(new BigInteger("0"))){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}
