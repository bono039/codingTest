import java.util.*;

class Solution {
    static int k;
    static int[][] dungeons;
    
    static boolean[] visited;
    static int cnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        
        visited = new boolean[dungeons.length];
        
        back(0, k);
        return cnt;
    }
    
    private static void back(int depth , int k) {
        for(int i = 0 ; i < dungeons.length ; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                back(depth + 1, k - dungeons[i][1]);
                visited[i] = false;
            }            
        }
        
        cnt = Math.max(cnt, depth);
    }
}