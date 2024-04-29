import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;
    
    static int N,M,P;
    static long[][] dp = new long[101][101];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    P = Integer.parseInt(st.nextToken());
	    
	    dp[0][0] = 1;
        
	    for(int i = 1 ; i <= P ; i++) {
	        for(int j = 0 ; j <= N ; j++) {
	            if(j > 0) {
	                dp[i][j] += dp[i-1][j-1] * (N-j+1);
	                dp[i][j] %= MOD;
	            }
	            if(j > M) {
	                dp[i][j] += dp[i-1][j] * (j-M);
	                dp[i][j] %= MOD;
	            }
	        }
	    }
	    
	    System.out.println(dp[P][N]);
	}
}
