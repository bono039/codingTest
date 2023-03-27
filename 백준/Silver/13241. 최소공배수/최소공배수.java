import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long mul = a * b;
		long gcd = getGCD(a, b);
		
		System.out.println(mul/gcd);
	}
	
	public static long getGCD(long a, long b) {
	    if(b == 0) return a;
	    else       return getGCD(b, a % b);
	}
}