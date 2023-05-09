import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    tree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < N - 1 ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    tree[s].add(e);
		    tree[e].add(s);
		}
		
		depth   = new int[N + 1];
		parent  = new int[N + 1];
		visited = new boolean[N + 1];
		
		depth[1] = 1;
		parent[1] = 0;
		
		DFS(1);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int result = LCA(a, b);
		    sb.append(result + "\n");   
		}
		System.out.println(sb);
		br.close();
	}
	
	static int LCA(int a, int b) {
	    if(depth[a] < depth[b]) {
	        int tmp = a;
	        a = b;
	        b = tmp;
	    }
	    
	    while(depth[a] != depth[b]) {
	        a = parent[a];
	    }
	    while(a != b) {
	        a = parent[a];
	        b = parent[b];
	    }
	    return a;
	}
	
	private static void DFS(int node) {
	    visited[node] = true;
	    
        for(int to : tree[node]) {
            if(!visited[to]) {
                visited[to] = true;
                depth[to]  = depth[node] + 1;                
                parent[to] = node;
                DFS(to);
            }
        }
	}
}