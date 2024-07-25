import java.util.*;

class Solution {
    static int k;
    static int[][] dungeons;
    static boolean[] chk;
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        
        chk = new boolean[dungeons.length];
        dfs(0, k);
                
        return answer;
    }
    
    private static void dfs(int cnt, int res) {        
        for(int i = 0 ; i < dungeons.length ; i++) {
            if(!chk[i] && dungeons[i][0] <= res) {
                chk[i] = true;
                dfs(cnt + 1, res - dungeons[i][1]);
                chk[i] = false;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
}