package baekjoon;

import java.io.*;
import java.util.*;

class Pillar implements Comparable<Pillar>{
    int left;
    int height;
    Pillar(int left, int height) {
        this.left = left;
        this.height = height;
    }
    @Override
    public int compareTo(Pillar o) {
        return this.left < o.left ? -1 : 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Stack<Pillar> leftStk = new Stack<>();
        Stack<Pillar> rightStk = new Stack<>();
        ArrayList<Pillar> pillars = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            pillars.add(new Pillar(L, H));
        }
        Collections.sort(pillars);  
        int maxHeight = 0;
        int len = pillars.size();
        for(int i = 0; i < len; i++) {
            if(maxHeight < pillars.get(i).height) {
                maxHeight = pillars.get(i).height;
                leftStk.push(pillars.get(i));
            }
        }
        maxHeight = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(maxHeight < pillars.get(i).height) {
                maxHeight = pillars.get(i).height;
                rightStk.push(pillars.get(i));
            }
        }

        int ans = (rightStk.peek().left - leftStk.peek().left + 1) * rightStk.peek().height;
        int beforeLeft = leftStk.pop().left;
        while(!leftStk.isEmpty()) {
            int left = leftStk.peek().left;
            int height = leftStk.peek().height;
            ans += (beforeLeft - left) * height;
            beforeLeft = left;
            leftStk.pop();
        }

        int beforeRight = rightStk.pop().left + 1;
        while(!rightStk.isEmpty()) {
            int right = rightStk.peek().left + 1;
            int height = rightStk.peek().height;
            ans += (right - beforeRight) * height;
            beforeRight = right;
            rightStk.pop();
        }

        System.out.println(ans);
    }
}
