import java.util.*;

class Solution {    
    static int n;
    static int[][] costs;
    
    static int[] parent;
    static int answer = 0;   
    
    public int solution(int n, int[][] costs) {
        this.n = n;
        this.costs = costs;
        
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }
        
        // == Arrays.sort(costs, (o1,o2) -> Integer.compare(o1[2], o2[2]));
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {    // 값이 작은 순 정렬
                return o1[2] - o2[2];
            }
        });
        
        // 크루스칼
        for(int i = 0 ; i < costs.length ; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    private static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) parent[b] = a;
    }
}