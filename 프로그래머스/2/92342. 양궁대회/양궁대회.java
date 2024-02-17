import java.util.*;

class Solution {
    static int n;
    static int[] info;
    
    static int[] lion = {-1};
    static int[] arrows = new int[11];
    
    static int max = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        
        dfs(0);
        
        if(max == -1) {
            lion = new int[]{-1};
        }
        return lion;
    }
    
    private static void dfs(int depth) {
        if(depth == n) {
            int diff = getScore();
            
            if(max <= diff) {
                max = diff;
                lion = arrows.clone();
            }
            return;
        }
        
        for(int i = 0 ; i < info.length && arrows[i] <= info[i] ; i++) {
            arrows[i]++;
            dfs(depth + 1);
            arrows[i]--;
        }
    }
    
    private static int getScore() {
        int apeach = 0;
        int lion = 0;
        
        for(int i = 0 ; i <= 10 ; i++) {
            if(info[i] == 0 && arrows[i] == 0)  continue;
            
            if(info[i] >= arrows[i])
                apeach += (10 - i);
            else
                lion += (10 - i);
        }
        
        int diff = lion - apeach;
        
        if(diff <= 0)
            return -1;
        return diff;
    }
}