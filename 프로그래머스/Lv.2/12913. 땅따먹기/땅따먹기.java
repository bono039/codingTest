import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        
        int[][] dp = new int[len][4];
        for(int i = 0 ; i < 4 ; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1 ; i < len ; i++) {
            dp[i][0] = getMax(dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + land[i][0];
            dp[i][1] = getMax(dp[i - 1][0], dp[i - 1][2], dp[i - 1][3]) + land[i][1];
            dp[i][2] = getMax(dp[i - 1][0], dp[i - 1][1], dp[i - 1][3]) + land[i][2];
            dp[i][3] = getMax(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + land[i][3];
        }
        
        for(int i = 0 ; i < 4 ; i++) {
            answer = Math.max(answer, dp[len - 1][i]);
        }

        return answer;
    }
    
    private static int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}