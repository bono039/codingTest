import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    
    static int N, D;
    static Road[] graph;
    static int[] dist;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
	    
	    dist = new int[D + 1];
	    for(int i = 0 ; i < dist.length ; i++) {
	        dist[i] = i;
	    }
	    
	    graph = new Road[N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int s = Integer.parseInt(st.nextToken());
	        int e = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        
	        graph[i] = new Road(s, e, v);
	    }
	    
	    dijkstra(0);
	    System.out.println(dist[D]);
	}
	
	private static void dijkstra(int start) {
	    PriorityQueue<Road> pq = new PriorityQueue<>();
	    pq.offer(new Road(start, 0, 0));
	    
	    dist[start] = 0;
	    
	    while(!pq.isEmpty()) {
	        Road cur = pq.poll();
	        int goal = cur.e;
	        
	        for(Road r : graph) {
	            if(r.s >= goal) {
    	            if(r.e > D) continue;
    	            
    	            if(dist[r.e] > dist[goal] + r.v + (r.s - goal)) {
    	                dist[r.e] = dist[goal] + r.v + (r.s - goal);
    	                pq.offer(new Road(goal, r.e, dist[r.e]));
    	            }	                
	            }
	        }
	        
	        dist[D] = Math.min(dist[goal] + D - goal, dist[D]);
	    }
	}
}

class Road implements Comparable<Road> {
    int s, e, v;
    
    public Road(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(Road r) {
        return this.v - r.v;
    }
}
