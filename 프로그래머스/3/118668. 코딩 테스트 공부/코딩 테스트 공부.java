import java.util.*;
// 알고력과 코딩력 얻는 최단시간
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        for(int i = 0 ; i < problems.length; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        
        alp = Math.min(maxAlp, alp);
        cop = Math.min(maxCop, cop);
        
        int maxCost = 100 * (maxAlp + maxCop);
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for(int i = 0 ; i <= maxAlp ; i++) {
            Arrays.fill(dp[i], maxCost);
        }
        dp[alp][cop] = 0;
        
        for(int i = alp ; i < maxAlp + 1 ; i++) {
            for(int j = cop ; j < maxCop + 1 ; j++) {
                if(i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                
                if(j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for(int k = 0 ; k < problems.length ; k++) {
                    int alpReq = problems[k][0],
                        copReq = problems[k][1],
                        alpRwd = problems[k][2],
                        copRwd = problems[k][3],
                        cost = problems[k][4];
                    
                    if(i >= alpReq && j >= copReq) {
                        int nextAlp = Math.min(maxAlp, i + alpRwd);
                        int nextCop = Math.min(maxCop, j + copRwd);
                        
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}