import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static List<Node>[] graph;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    graph = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0 ; i < N-1 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        
	        graph[a].add(new Node(b, v));
	        graph[b].add(new Node(a, v));
	    }
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        chk = new boolean[N+1];
	        bfs(a,b);
	    }
	    System.out.println(sb.toString());
	}
	
	private static void bfs(int start, int end) {
	    Queue<Node> q = new ArrayDeque<>();
	    q.add(new Node(start, 0));
	    
	    chk[start] = true;
	    
	    while(!q.isEmpty()) {
	        Node now = q.poll();
	        
	        if(now.idx == end) {
	            sb.append(now.v).append("\n");
	            return;
	        }
	        
	        for(Node next : graph[now.idx]) {
	            if(!chk[next.idx]) {
	                chk[next.idx] = true;
	                q.add(new Node(next.idx, now.v + next.v));
	            }
	        }
	    }
	}
}

class Node {
    int idx, v;
    
    public Node(int idx, int v) {
        this.idx = idx;
        this.v = v;
    }
}
