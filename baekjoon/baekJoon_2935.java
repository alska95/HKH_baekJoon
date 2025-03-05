package baekjoon;

import java.io.*;
import java.math.BigInteger;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger a = new BigInteger(br.readLine());
		String op = br.readLine();
		BigInteger b = new BigInteger(br.readLine());

		if(op.equals("+")) {
			bw.write(a.add(b).toString());
		}else{
			bw.write(a.multiply(b).toString());
		}
		bw.close();
	}
}
