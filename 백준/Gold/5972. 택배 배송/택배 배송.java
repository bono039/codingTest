import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] dist;
    static List<Node>[] A;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    A = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++)   A[i] = new ArrayList<>();
	    
	    dist = new int[N+1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    visited = new boolean[N+1];
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        A[a].add(new Node(b,c));
	        A[b].add(new Node(a,c));
	    }
	    
	    System.out.println(dijkstra());
	}
	
	private static int dijkstra() {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(1, 0));
	    
	    dist[1] = 0;

        while(!pq.isEmpty())	     {
            Node now = pq.poll();
            
            if(visited[now.e])  continue;
            visited[now.e] = true;
            
            for(Node next : A[now.e]) {
                if(dist[next.e] > dist[now.e] + next.v) {
                    dist[next.e] = dist[now.e] + next.v;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }
	    
	    return dist[N];
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