import java.util.*;
import java.io.*;

public class Main {
    static int N,M,K;
    static int[][] grid, dp;
    static int rx = 0, ry = 0;
    static int ox = 0, oy = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] str = br.readLine().split(" ");
	    N = Integer.parseInt(str[0]);
	    M = Integer.parseInt(str[1]);
	    K = Integer.parseInt(str[2]);
	    
	    grid = new int[N][M];
	    dp = new int[N][M];
	    
	    int num = 1;
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            grid[i][j] = num++;
	            
	            if(grid[i][j] == K) {
	                ox = i;
	                oy = j;
	            }
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++)    dp[i][0] = 1;
	    for(int j = 0 ; j < M ; j++)    dp[0][j] = 1;
	    
	    for(int i = 0 ; i <= ox ; i++) {
	        for(int j = 0 ; j <= oy ; j++) {
	            if(i == 0 || j == 0)    continue;	            
	            dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        }
	    }
	    
	    for(int i = ox ; i < N ; i++)    dp[i][oy] = dp[ox][oy];
	    for(int j = oy ; j < M ; j++)    dp[ox][j] = dp[ox][oy];
	    
	    for(int i = ox ; i < N ; i++) {
	        for(int j = oy ; j < M ; j++) {
	            if(i == ox || j == oy)  continue;	            
	            dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        }
	    }
	    
	    System.out.println(dp[N-1][M-1]);
	}
}
