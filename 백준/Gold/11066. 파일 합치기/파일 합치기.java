import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int[] sum = new int[501];
    static int[][] dp = new int[501][501];
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    
	    for(int i = 0 ; i < T ; i++) {
	        int K = Integer.parseInt(br.readLine());
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 1 ; j <= K ; j++) {
	            sum[j] = sum[j-1] + Integer.parseInt(st.nextToken());
	        }
	        
	        solve(K);
	        sb.append(dp[1][K]).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
	
	private static void solve(int k) {
	    for(int i = 2 ; i <= k ; i++) {
	        for(int j = i-1 ; j >= 1 ; j--) {
	            dp[j][i] = Integer.MAX_VALUE;
	            
	            for(int x = j ; x < i ; x++) {
	                dp[j][i] = Math.min(dp[j][i], dp[j][x] + dp[x+1][i]);
	            }
	            
	            dp[j][i] += sum[i] - sum[j - 1];
	        }
	    }
	}
}
