import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] P = new long[101];
		P[1] = P[2] = P[3] = 1;
		for(int i = 4 ; i <= 100 ; i++) {
		    P[i] = P[i - 3] + P[i - 2];
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
		    int num = Integer.parseInt(br.readLine());
		    sb.append(P[num]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}