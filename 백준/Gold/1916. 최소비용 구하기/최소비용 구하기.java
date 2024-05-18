import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] A;
    static boolean[] visited;
    
    static int[] D;
    static int MAX = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		A = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];
		
		D = new int[N + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		while(M --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    
		    A[s].add(new Node(e, v));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
	}
	
	private static int dijkstra(int start, int end) {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    
	    D[start] = 0;
	    
	    while(!pq.isEmpty()) {
	        Node now = pq.poll();
	        
	        if(visited[now.node])   continue;
	        visited[now.node] = true;
	        
	        for(Node next : A[now.node]) {
	            if(D[next.node] > D[now.node] + next.val) {
	                D[next.node] = D[now.node] + next.val;
	                pq.add(new Node(next.node, D[next.node]));
	            }
	        }
	    }
	    return D[end];
	    
	}
}

class Node implements Comparable<Node> {
    int node, val;
    
    public Node(int node, int val) {
        this.node = node;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node e) {
        return this.val - e.val;
    }
}
