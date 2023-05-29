import java.util.*;
import java.io.*;

public class Main {
    static int t;
    static long[] dp;
    static long mod = 1_000_000_009;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		dp = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4 ; i < dp.length ; i++) {
		    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % mod;
		}
				
		for(int i = 0 ; i < t ; i++) {
		    int num = Integer.parseInt(br.readLine());
		    System.out.println(dp[num]);
		}
	}
}