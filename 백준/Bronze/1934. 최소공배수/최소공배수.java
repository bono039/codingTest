import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    
		    int result = A * B / gcd(A, B);
		    System.out.println(result);
		}
	}
	
	// 최대공약수 계산
	public static int gcd(int a, int b) {
	    if(b == 0)
	        return a;
	    else
	        return gcd(b, a % b);
	}
}