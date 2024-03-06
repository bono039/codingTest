import java.util.*;

class Solution {
    static int[] a;
    static int[][] edges;
    
    static long answer = 0;
    static long[] longArr;
    
    static List<Integer>[] A;
    static boolean[] visited;
    
    public long solution(int[] a, int[][] edges) {
        this.a = a;
        this.edges = edges;
        
        longArr = new long[a.length];
        A = new ArrayList[a.length];
        visited = new boolean[a.length];
        
        long sum = 0;
        for(int i = 0 ; i < a.length ; i++) {
            sum += a[i];
            A[i] = new ArrayList<>();
            longArr[i] = a[i];
        }
        
        if(sum != 0)    return -1;
        
        for(int i = 0 ; i < edges.length ; i++) {
            A[edges[i][0]].add(edges[i][1]);
            A[edges[i][1]].add(edges[i][0]);
        }
        
        dfs(0);
        
        return answer;
    }
    
    private static long dfs(int v) {
        visited[v] = true;
        
        for(int i = 0 ; i < A[v].size() ; i++) {
            int next = A[v].get(i);
            
            if(!visited[next])
                longArr[v] += dfs(next);
        }
        
        answer += Math.abs(longArr[v]);
        
        return longArr[v];
    }
}