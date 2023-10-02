import java.util.*;

class Solution {
    static final int mod = 1_000_000_007;
    
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        if(n <= 2) {
            return dp[n];
        }
        
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        
        return dp[n] % mod;
    }
}