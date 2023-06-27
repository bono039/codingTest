import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static PriorityQueue<Edge> edges;
    static int[] parent;
    static int useEdge = 0;
    static int result = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new PriorityQueue<>();
		parent = new int[V + 1];
		for(int i = 1 ; i <= V ; i++) {
		    parent[i] = i;
		}
		
		while(E --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    
		    edges.add(new Edge(a, b, c));
		}
		
		while(useEdge < V - 1) {
		    Edge now = edges.poll();
		    
		    if(find(now.s) != find(now.e)) {
		        union(now.s, now.e);
		        result += now.v;
		        useEdge++;
		    }
		}
		System.out.println(result);
	}
	
	private static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b)  parent[b] = a;
	}
	private static int find(int a) {
	    if(a == parent[a])  return a;
	    return parent[a] = find(parent[a]);
	}
}

class Edge implements Comparable<Edge> {
    int s, e, v;
    
    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(Edge edge) {
        return this.v - edge.v;
    }
}
