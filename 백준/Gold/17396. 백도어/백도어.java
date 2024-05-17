import java.util.*;
import java.io.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    
    static int N,M;
    static boolean[] sight;
    
    static List<Node>[] graph;
    static long[] dist;    
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    sight = new boolean[N];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        int num = Integer.parseInt(st.nextToken());
	        sight[i] = (num == 1) ? false : true;
	    }
	    
	    graph = new ArrayList[N];
	    for(int i = 0 ; i < N ; i++)    graph[i] = new ArrayList<>();
	    
	    dist = new long[N];
	    Arrays.fill(dist, INF);
	    	    
	    for(int i = 0 ; i < M ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int t = Integer.parseInt(st.nextToken());
	        
	        graph[a].add(new Node(b, t));
	        graph[b].add(new Node(a, t));
	    }
        
	    visited = new boolean[N];
	    dijkstra();
	    System.out.println(dist[N-1] == INF ? -1 : dist[N-1]);
	}
	
	private static void dijkstra() {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(0,0));
	    
	    dist[0] = 0;
	    
	    while(!pq.isEmpty()) {
	        Node now = pq.poll();
	        
	        if(visited[now.e])  continue;
	        
	        visited[now.e] = true;
	        
	        for(Node next : graph[now.e]) {
	            if(next.e != N-1 && !sight[next.e]) continue;
	            
	            if(dist[next.e] > dist[now.e] + next.v) {
	                dist[next.e] = dist[now.e] + next.v;
	                pq.add(new Node(next.e, dist[next.e]));
	            }
	        }
	    }
	}
}

class Node implements Comparable<Node> {
    int e;
    long v;
    
    public Node(int e, long v) {
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(Node n) {
        return Long.compare(this.v, n.v);
    }
}
