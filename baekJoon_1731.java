import java.util.*;

public class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] n = new int[num];
        for(int i=0;i<n.length;i++)
        {
        	n[i] = sc.nextInt();
        }
        sc.close();
        if(n[2]-n[1] == n[1]-n[0])
        	System.out.print(n[n.length-1] + (n[1]-n[0]));
    	
        else
        	System.out.print(n[n.length-1] * (n[1]/n[0]));
    }
}