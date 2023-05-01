import java.util.*;
import java.io.*;

public class Main {
    public static int V, E, K;
    public static int[] D;
    public static boolean visited[];
    
    public static ArrayList<ArrayList<Edge>> A;
    public static PriorityQueue<Edge> pq = new PriorityQueue<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		visited = new boolean[V + 1];		
		
		D = new int[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		A = new ArrayList<>();
		for(int i = 0 ; i <= V ; i++) {
		    A.add(new ArrayList<>());
		}
		
		for(int i = 1 ; i <= E ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    
		    A.get(u).add(new Edge(v, w));
		}
		
		
		// 다익스트라 수행
		pq.add(new Edge(K, 0));
		D[K] = 0;
		
		while(!pq.isEmpty()) {
		    Edge current = pq.poll();
		    int c_ver = current.vertex;
		    if(visited[c_ver]) continue;
		    visited[c_ver] = true;
		    
		    for(int i = 0 ; i < A.get(c_ver).size() ; i++) {
		        Edge tmp = A.get(c_ver).get(i);
		        
		        int next  = tmp.vertex;
		        int value = tmp.value;
		        
		        if(D[next] > D[c_ver] + value) {
		            D[next] = D[c_ver] + value;
		            pq.add(new Edge(next, D[next]));
		        }
		    }
		}
		
		for(int i = 1 ; i <= V ; i++) {
		    if(visited[i])
		        System.out.println(D[i]);
		    else
		        System.out.println("INF");
		}
	}
}

class Edge implements Comparable<Edge> {
    int vertex, value;
    
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value  = value;
    }
    
    public int compareTo(Edge e) {
        return Integer.compare(this.value, e.value);
    }
}