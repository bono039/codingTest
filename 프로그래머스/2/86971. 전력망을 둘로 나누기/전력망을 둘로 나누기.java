import java.util.*;
// 전선 중 하나를 끊어 네트워크를 2개로 분할 (송전탑 개수 최대한 비슷하게)
class Solution {
    static int n;
    static int[][] wires;
    
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) { // 송전탑 개수, 전선정보
        this.n = n;
        this.wires = wires;
        
        A = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i++) A[i] = new ArrayList<>();
        
        // 양방향 간선
        for(int i = 0 ; i < wires.length ; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            A[a].add(b);
            A[b].add(a);
        }
        
        for(int i = 0 ; i < wires.length ; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            visited = new boolean[n + 1];
            
            // 해당 간선을 그래프에서 제거
            A[a].remove(Integer.valueOf(b));
            A[b].remove(Integer.valueOf(a));
            
            int cnt = dfs(1);   // 임의의 시작점에서 dfs 탐색
            
            int diff = Math.abs(cnt - (n - cnt));   // |송전탑 개수 차이|
            min = Math.min(min, diff);
            
            // 그래프에 다시 간선 추가
            A[a].add(b);
            A[b].add(a);
        }
        
        return min;
    }
    
    static int dfs(int v) {
        visited[v] = true;
        int cnt = 1;
        
        for(int next : A[v]) {
            if(!visited[next]) {
                cnt += dfs(next);
            }
        }
        
        return cnt;
        
    }
}