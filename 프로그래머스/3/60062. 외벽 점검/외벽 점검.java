import java.util.*;

class Solution {    
    static int n;
    static int[] weak, dist;
    static int[][] weakCases;
    
    // dfs용
    static boolean[] visited;
    static int[] dist_case;
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        
        weakCases = new int[weak.length][weak.length];
                        
        Arrays.sort(dist);
        makeWeakCases();
        
        visited = new boolean[dist.length];
        dist_case = new int[dist.length];   // 순열 저장할 배열
        perm(0);

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
    
    private static void makeWeakCases() {
        int[] wc = weak.clone();
        weakCases[0] = wc.clone();
        
        for(int i = 1 ; i < weak.length ; i++) {
            int tmp = wc[0];
            
            for(int j = 1 ; j < weak.length ; j++) {
                wc[j - 1] = wc[j];
            }
            
            wc[weak.length - 1] = tmp + n;
            weakCases[i] = wc.clone();
        }
    }
    
    private static void perm(int depth) {
        if(depth == dist.length) {
            for(int[] wc : weakCases)
                chk(dist_case, wc);
            return;
        }
        
        for(int i = 0 ; i < dist.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dist_case[depth] = dist[i];
                
                perm(depth + 1);
                
                dist_case[depth] = 0;
                visited[i] = false;
            }
        }
    }
    
    private static void chk(int[] dist_case, int[] wc) {
        int now = 0;
        int next;
        
        int idx = 0;
        
        while(now < wc.length && idx < dist_case.length) {
            next = now + 1;
            
            while(next < wc.length && wc[now] + dist_case[idx] >= wc[next]) {
                next++;
            }
            
            now = next;
            idx++;
        }
        
        if(now == wc.length && idx < answer)
            answer = idx;
    }
}