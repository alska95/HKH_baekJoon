package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int l = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		
		int day = 0;
		while(true) {
			a -= c;
			b -=d ;
			day++;
			
			if(a <= 0 && b <= 0) {
				break;
			}
		}
		
		System.out.println(l - day);
	}

}
