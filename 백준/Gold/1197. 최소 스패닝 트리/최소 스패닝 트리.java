import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<pEdge> pq;
    static int[] parent;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		for(int i = 1 ; i <= V ; i++) {
		    parent[i] = i;
		}
		
		pq = new PriorityQueue<>();
		for(int i = 1 ; i <= E ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int s  = Integer.parseInt(st.nextToken()); 
		    int e    = Integer.parseInt(st.nextToken()); 
		    int v = Integer.parseInt(st.nextToken());
		    
		    pq.add(new pEdge(s, e, v));
		}
		
		int useEdge = 0;
		int result = 0;
		while(useEdge < V - 1) {
		    pEdge now = pq.poll();
		    
		    if(find(now.s) != find(now.e)) {
		        union(now.s, now.e);
		        result += now.v;
		        useEdge++;
		    }
		}
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b) parent[b] = a;
	}
	public static int find(int a) {
	    if(a == parent[a]) return a;
	    else               return parent[a] = find(parent[a]);
	}
}

class pEdge implements Comparable<pEdge> {
    int s, e, v;
    
    pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(pEdge e) {
        return this.v - e.v;
    }
}