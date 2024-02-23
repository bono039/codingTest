import java.util.*;

class Solution {
    static int n;
    static int[][] wires;
    
    static List<Integer>[] A;
    static boolean[] visited;
    
    static int diff = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) { // 송전탑 수, 전선 정보
        this.n = n;
        this.wires = wires;
        
        A = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) {
            A[i] = new ArrayList<>();
        }
        
        for(int[] w : wires) {
            A[w[0]].add(w[1]);
            A[w[1]].add(w[0]);
        }
        
        // 전선들 중 "하나" 끊어서 송전탑 개수가 가능한 비슷하도록
        for(int[] w : wires) {   
            visited = new boolean[n + 1];
            
            // 1. 전선줄 하나 끊어보기
            A[w[0]].remove(Integer.valueOf(w[1]));
            A[w[1]].remove(Integer.valueOf(w[0]));
            
            // 2. 두 전력망이 가진 송전탑 개수 차이 계산하기
            int cnt = bfs(1);   // 임의의 시작점에서 bfs
            diff = Math.min(diff, Math.abs(cnt - (n-cnt)));
            
            // 3. 전선줄 원상복구
            A[w[0]].add(w[1]);
            A[w[1]].add(w[0]);            
        }       
        
        return diff;
    }
    
    private static int bfs(int num) {
        int cnt = 1;
        visited[num] = true;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);       
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : A[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}