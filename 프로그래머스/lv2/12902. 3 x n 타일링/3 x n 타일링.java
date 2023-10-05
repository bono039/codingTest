import java.util.*;

class Solution {
    static final int mod = 1_000_000_007;
    
    public int solution(int n) {
        int answer = 0;
        
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i = 4 ; i <= n ; i += 2) {
             dp[i] = dp[i - 2] * 3;

             for(int j = i - 4 ; j >= 0 ; j -= 2) {
                 dp[i] += dp[j] * 2;
             }
             dp[i] %= mod;

        }
        
        return (int)dp[n];
    }
}