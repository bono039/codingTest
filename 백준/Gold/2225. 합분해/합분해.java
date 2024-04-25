import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] str = br.readLine().split(" ");
	    int N = Integer.parseInt(str[0]);
	    int K = Integer.parseInt(str[1]);
	    
	    long[][] dp = new long[201][201];
	    for(int i = 1 ; i <= K ; i++) {
	        dp[i][0] = 1;
	    }
	    
	    for(int i = 1 ; i <= K ; i++) {
	        for(int j = 1 ; j <= N ; j++) {
	            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
	        }
	    }
	    
	    System.out.println(dp[K][N]);
	}
}
