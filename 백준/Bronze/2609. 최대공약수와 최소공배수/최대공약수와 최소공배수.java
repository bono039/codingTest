import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		System.out.println(GCD(n, m));
		System.out.println((n * m) / GCD(n, m));
	}
	
	static int GCD(int a, int b) {
        int max = 1;
	    for(int i = 2 ; i <= Math.min(a, b) ; i++) {
	        if(a % i == 0 && b % i == 0) {
	            max = Math.max(max, i);
	        }
	    }
	    return max;
	}
}