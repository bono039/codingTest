import java.util.*;
import java.io.*;

public class Main {
    static int N, max;
    static int[] A, dp;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());	    
	    A = new int[N];
	    dp = new int[N];
        
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
        
	    max = 1;
	    
	    for(int i = 0 ; i < N ; i++) {
	        dp[i] = 1;
	        
	        for(int j = 0 ; j < i ; j++) {
	            if(A[j] < A[i]) {
	                dp[i] = Math.max(dp[i], dp[j] + 1);
	                max = Math.max(max, dp[i]);
	            }
	        }
	    }
	    
	    System.out.println(max);
	}
}