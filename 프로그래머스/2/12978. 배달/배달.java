import java.util.*;

class Solution {
    static final int MAX = Integer.MAX_VALUE;
    
    static int N, K;
    static int[][] road;
    static int[][] dp;
    
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.road = road;
        this.K = K;
        
        dp = new int[N+1][N+1];
        for(int i = 0 ; i <= N ; i++) {
            Arrays.fill(dp[i], MAX);
        }
        for(int i = 1 ; i <= N ; i++)
            dp[i][i] = 0;
        
        for(int[] r : road) {
            dp[r[0]][r[1]] = Math.min(dp[r[0]][r[1]], r[2]);
            dp[r[1]][r[0]] = Math.min(dp[r[0]][r[1]], r[2]);;
        }
        
        for(int k = 1 ; k <= N ; k++) {
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(i == j || j == k || k == i)  continue;
                    
                    if(dp[i][k] != MAX && dp[k][j] != MAX) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }            
        }
                
        int answer = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(dp[1][i] <= K)
                answer++;
        }

        return answer;
    }
}