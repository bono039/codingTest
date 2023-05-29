import java.util.*;
import java.io.*;

public class Main {
    static int N, S, M;
    static int[] V;
    static int[][] dp;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		V = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
		    V[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[M + 1][N];
		for(int[] arr : dp) {
		    Arrays.fill(arr, -2);
		}
		
		System.out.println(solve(S, 0));
		br.close();
	}
	
	public static int solve(int sum, int idx) {
	    if(sum > M || sum < 0)
	        return -1;
	    
	    if(idx == N)
	        return sum;
	   
	    if(dp[sum][idx] != -2)
	        return dp[sum][idx];
	        
	    return dp[sum][idx] = Math.max(dp[sum][idx], Math.max(solve(sum + V[idx], idx + 1), solve(sum - V[idx], idx + 1)));
	}
}