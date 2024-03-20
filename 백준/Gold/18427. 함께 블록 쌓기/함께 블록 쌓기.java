import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 10007;
    
    static int N,M,H;
    static int[][] dp;
    static List<Integer>[] list;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    H = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[N+1];
	    
	    for(int i = 1 ; i <= N ; i++) {
	        list[i] = new ArrayList<>();
	        
	        String[] str = br.readLine().split(" ");
	        for(String s : str) {
	            int num = Integer.parseInt(s);
	            list[i].add(num);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	        }
	    }
	    
	    dp = new int[N+1][1001];
	    for(int i = 0 ; i <= N ; i++)
	        dp[i][0] = 1;
	        
	    for(int i = 1 ; i <= N ; i++) {
	        for(int j = 1 ; j <= H ; j++) {
	            for(int num : list[i]) {
	                if(j >= num) {
    	                dp[i][j] += dp[i-1][j - num];
    	                dp[i][j] %= MOD;
	                }
	            }
	            dp[i][j] += dp[i-1][j];
    	        dp[i][j] %= MOD;
	        }
	    }
	    
	    System.out.println(dp[N][H]);
	}
}
