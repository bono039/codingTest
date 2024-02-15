import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] dp;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine()); 
	    
	    dp = new int[M + 1][M + 1];	    
	    for(int i = 1 ; i <= M ; i++) {
	        dp[i][i] = 1;
	        dp[i][1] = 1;
	    }
	    
	    for(int i = 1 ; i <= M ; i++) {
	        for(int j = 1 ; j <= i ; j++) {
	            if(i == j)  continue;
	            
	            dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
	        }
	    }
	    
	    System.out.println(dp[M][N]);
	}
}
