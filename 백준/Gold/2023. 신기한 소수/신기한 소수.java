import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		System.out.println(sb);
	}

	private static void dfs(int n, int digit) {
        if(digit == N) {
            if(isPrime(n)) {
                sb.append(n).append("\n");
                return;
            }
        }
	    
        for(int i = 1 ; i <= 9 ; i++) {
            if(i % 2 == 0)  continue;
            
            if(isPrime(n*10 + i)) {
                dfs(n*10 + i, digit + 1);
            }
        }
	}
	
	private static boolean isPrime(int num) {
	    if(num == 1) return false;
	    
	    for(int i = 2 ; i <= (int)Math.sqrt(num) ; i++) {
	        if(num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}