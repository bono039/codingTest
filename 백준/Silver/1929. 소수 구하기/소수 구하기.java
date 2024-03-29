import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2 ; i <= n ; i++) {
		    if(isPrime[i]) {
		        for(int j = i + i ; j <= n ; j += i) {
		            isPrime[j] = false;
		        }
		    }
		}
		
		for(int i = m ; i <= n ; i++) {
		    if(isPrime[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}