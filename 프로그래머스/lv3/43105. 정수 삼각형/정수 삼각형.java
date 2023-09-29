import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[501][501];
        dp[0][0] = triangle[0][0];
        
        int max = 0;
        
        for(int i = 1 ; i < triangle.length ; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][triangle[i].length - 1] = dp[i-1][i-1] + triangle[i][i];
        }
        
        for(int i = 1 ; i < triangle.length ; i++) {
            for(int j = 0 ; j < triangle[i].length ; j++) {
                if(j == 0 || j == i)    continue;
                
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}