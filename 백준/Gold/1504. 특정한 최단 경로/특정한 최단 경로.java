import java.util.*;
import java.io.*;

public class Main {
    static int INF = 200000*100;
    
    static int N,E;
    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    E = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++)   list[i] = new ArrayList<>();
	    
	    dist = new int[N+1];
	    visited = new boolean[N+1];
	    
	    while(E --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    int v1 = Integer.parseInt(st.nextToken());
	    int v2 = Integer.parseInt(st.nextToken());
	    
	    int ans1 = 0;
	    ans1 += dijkstra(1, v1);
	    ans1 += dijkstra(v1, v2);
	    ans1 += dijkstra(v2, N);
	    
	    int ans2 = 0;
	    ans2 += dijkstra(1, v2);
	    ans2 += dijkstra(v2, v1);
	    ans2 += dijkstra(v1, N);
	    
	    int answer = 0;
	    answer = (ans1 >= INF && ans2 >= INF) ? -1 : Math.min(ans1, ans2);
	    System.out.println(answer);
	}
	
	private static int dijkstra(int start, int end) {
	    Arrays.fill(visited, false);
	    Arrays.fill(dist, INF);
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    
	    dist[start] = 0;
	    
	    while(!pq.isEmpty()) {
	        Node now = pq.poll();
	        
	        if(visited[now.e])  continue;
	        visited[now.e] = true;
	        
	        for(Node next : list[now.e]) {
	            if(dist[next.e] > now.v + next.v) {
	                dist[next.e] = now.v + next.v;
	                pq.add(new Node(next.e, dist[next.e]));
	            }
	        }
	    }
	    
	    return dist[end];
	}
}

class Node implements Comparable<Node> {
    int e, v;
    
    public Node(int e, int v) {
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.v - n.v;
    }
}