import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[][] dp = new int[31][31];
	    for(int i = 1 ; i <= n ; i++) {
	        dp[i][1] = 1;
	        dp[i][i] = 1;
	    }
	    
	    for(int i = 2 ; i <= n ; i++) {
	        for(int j = 2 ; j < i ; j++) {
	            dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
	        }
	    }
	    
	    System.out.println(dp[n][k]);
	}
}
