import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] A = new int[n + 1][n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    for(int j = 1 ; j <= i ; j++) {
		        A[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		if(n == 1) {
		    System.out.println(A[1][1]);
		    return;
		}
		
		int[][] dp = new int[501][501];
		dp[1][1] = A[1][1];
		
		for(int i = 2 ; i <= n ; i++) {
		    dp[i][1] = dp[i-1][1] + A[i][1];    
		}
		
		int max = 0;
		for(int i = 2 ; i <= n ; i++) {
		    for(int j = 1 ; j <= i ; j++) {
		        if(i - 1 < 1 || j - 1 < 1) continue;
		        
		        dp[i][j] = Math.max(dp[i][j],  Math.max(dp[i-1][j], dp[i-1][j-1]) + A[i][j]);
		        max = Math.max(max, dp[i][j]);
		    }
		}
		
		System.out.println(max);
	}
}