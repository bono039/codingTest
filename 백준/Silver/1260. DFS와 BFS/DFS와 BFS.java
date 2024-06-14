import java.util.*;
import java.io.*;

public class Main {
    static int N,M,V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    V = Integer.parseInt(st.nextToken());
	    
	    graph = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        graph[a].add(b);
	        graph[b].add(a);
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        Collections.sort(graph[i]);
	    }
	    
	    visited = new boolean[N+1];
	    dfs(V, 0);
	    sb.append("\n");
	    
	    visited = new boolean[N+1];
	    bfs(V);
	    
	    System.out.println(sb.toString());
	}
	
	private static void dfs(int idx, int depth) {
	    if(depth == N)  return;
	    
	    visited[idx] = true;
	    sb.append(idx + " ");
	    
	    for(int next : graph[idx]) {
	        if(!visited[next]) {
        	    dfs(next, depth + 1);
	        }
	    }
	}
	
	private static void bfs(int idx) {
	    Queue<Integer> q = new ArrayDeque<>();
	    q.add(idx);
	    
	    visited[idx] = true;
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        sb.append(now + " ");
	        
	        for(int next : graph[now]) {
	            if(!visited[next]) {
	                visited[next] = true;
	                q.add(next);
	            }
	        }
	    }
	}
}
