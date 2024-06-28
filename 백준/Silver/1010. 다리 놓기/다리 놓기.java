import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    
	    dp = new int[31][31];
	    for(int i = 0 ; i < 31 ; i++) {
	        dp[i][0] = 1;
	        dp[i][i] = 1;
	        dp[i][1] = i;
	    }
	    
	    for(int i = 1 ; i < 31 ; i++) {
	        for(int j = 2 ; j < 31 ; j++)
	            dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
	    }
	    
	    while(T --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        sb.append(dp[y][x]).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
}