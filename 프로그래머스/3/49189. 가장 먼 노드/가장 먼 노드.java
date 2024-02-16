import java.util.*;

class Solution {
    static int n;
    static int[][] edge;
    static List<Integer>[] A;
    static int[] dist;
    static int answer = 0;
    
    public int solution(int n, int[][] edge) {
        this.n = n;
        this.edge = edge;
        
        A = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) {
            A[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < edge.length ; i++) {
            A[edge[i][0]].add(edge[i][1]);
            A[edge[i][1]].add(edge[i][0]);
        }
        
        dist = new int[n+1];
        bfs(1);
        
        return answer;
    }
    
    private static void bfs(int num) {
        int max = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        
        boolean[] visited = new boolean[n+1];
        visited[num] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : A[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.add(next);
                    max = Math.max(max, dist[next]);
                }                
            }            
        }
        
        for(int i : dist) {
            if(i == max)
                answer++;
        }
    }
}