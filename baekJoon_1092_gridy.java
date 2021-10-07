import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st =new StringTokenizer(br.readLine() , " ");
        ArrayList<Integer> crain = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            crain.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st =new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < m ; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        Collections.sort(crain, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        int result = 0;
        if(box.get(0) > crain.get(0)){
            result = -1;
        }else{
            while(!box.isEmpty()){
                int iter =0;
                for(int i = 0; i < n ;){
                    if(iter >= box.size())
                        break;
                    if(box.get(iter) <= crain.get(i)){
                        box.remove(iter);
                        i++;
                    }else{
                        iter++;
                    }
                }
                result++;
            }
        }
        bw.write(result+"");
        bw.close();
    }

}
