import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Integer>> graph;
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
                
        for(int[] r : roads) {            
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dijkstra(n, destination);
        
        int[] answer = new int[sources.length];
        for(int i = 0 ; i < sources.length ; i++) {
            int v = dist[sources[i]];
            answer[i] = (v == INF) ? -1 : v;
        }
        
        return answer;
    }
    
    private static void dijkstra(int n, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dist[destination] = 0;        
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i = 0 ; i < graph.get(now).size() ; i++) {
                int next = graph.get(now).get(i);
                
                if(dist[now] + 1 < dist[next]) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }     
    }
}