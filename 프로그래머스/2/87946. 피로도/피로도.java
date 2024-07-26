import java.util.*;

class Solution {
    static int k, len;
    static int[][] dungeons;
    static boolean[] chk;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        len = dungeons.length;
        
        chk = new boolean[len];
        dfs(0, k);
        return max;
    }
    
    private static void dfs(int depth, int v) {        
        for(int i = 0 ; i < len ; i++) {
            if(!chk[i] && dungeons[i][0] <= v) {
                chk[i] = true;
                dfs(depth + 1, v - dungeons[i][1]);
                chk[i] = false;
            }
        }
        
        max = Math.max(max, depth);
    }    
}