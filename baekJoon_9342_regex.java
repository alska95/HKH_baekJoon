import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = Integer.parseInt(br.readLine()) ; i > 0 ; i--){
            bw.write(Pattern.matches("^(A|B|C|D|E|F)?A+F+C+(A|B|C|D|E|F)?$", br.readLine()) ? "Infected!\n" : "Good\n");
            bw.flush();
        }
        bw.close();
    }
}