import java.util.*;
import java.io.*;

public class Main {
    static int n, max = 0;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());	    
	    graph = new ArrayList[n+1];
	    for(int i = 0 ; i <= n ; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0 ; i < n-1 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        int dist = Integer.parseInt(st.nextToken());
	        
	        graph[x].add(new Node(y, dist));
	        graph[y].add(new Node(x, dist));
	    }
	    
	    for(int i = 1 ; i <= n ; i++) {
	        visited = new boolean[n+1];
	        dfs(i, 0);
	    }
	    
	    System.out.println(max);
	}
	
	private static void dfs(int idx, int sum) {
	    visited[idx] = true;
	    max = Math.max(max, sum);
	    
	    for(Node now : graph[idx]) {
	        if(!visited[now.idx]) {
	            dfs(now.idx, sum + now.val);
	        }
	    }
	}
}

class Node {
    int idx, val;
    
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}