import java.util.*;

class Solution {
    static int MAX = 200 * 100_000 + 1;
    static ArrayList<ArrayList<Node>> graph;
    static int answer = Integer.MAX_VALUE;
        
    public int solution(int n, int s, int a, int b, int[][] fares) {                
        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] f : fares) {
            graph.get(f[0]).add(new Node(f[1], f[2]));
            graph.get(f[1]).add(new Node(f[0], f[2]));
        }       
        
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start  = new int[n+1];
        
        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start,  MAX);
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start  = dijkstra(s, start);
        
        for(int i = 1 ; i <= n ; i++) {
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }
                
        return answer;
    }
    
    private static int[] dijkstra(int start, int[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        arr[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
                        
            if(now.val > arr[now.idx])    continue;
            
            ArrayList<Node> nodes = graph.get(now.idx);
            for(Node n : nodes) {                
                if(arr[n.idx] > arr[now.idx] + n.val) {
                    arr[n.idx] = arr[now.idx] + n.val;
                    pq.offer(new Node(n.idx, now.val));
                }
            }
        }
        
        return arr;
    }
}

class Node implements Comparable<Node> {
    int idx, val;
    
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.val -  n.val;
    }
}