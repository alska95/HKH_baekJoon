import java.io.*;
import java.util.*;

public class Main {
    static class WordSet {
        int index;
        String word;

        public WordSet(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<WordSet> results = new ArrayList<>();
        for(int i = m ; i <= n ; i++){
            int target = i;
            String result = "";
            while(true) {
                int key = target;
                if (target >= 10) {
                    key = target / 10;
                }

                switch (key) {
                    case 0:
                        result += "zero";
                        break;
                    case 1:
                        result += "one";
                        break;
                    case 2:
                        result += "two";
                        break;
                    case 3:
                        result += "three";
                        break;
                    case 4:
                        result += "four";
                        break;
                    case 5:
                        result += "five";
                        break;
                    case 6:
                        result += "six";
                        break;
                    case 7:
                        result += "seven";
                        break;
                    case 8:
                        result += "eight";
                        break;
                    case 9:
                        result += "nine";
                        break;
                }
                if(target < 10)
                    break;
                target %= 10;
                result += " ";
            }
            results.add(new WordSet(i , result));
        }
        Collections.sort(results, new Comparator<WordSet>() {
            @Override
            public int compare(WordSet o1, WordSet o2) {
                return o1.word.compareTo(o2.word);
            }
        });
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (WordSet result : results) {
            sb.append(result.index);
            counter++;
            if(counter >= 10){
                sb.append("\n");
                counter = 0;
            }else{
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        bw.close();
    }
}