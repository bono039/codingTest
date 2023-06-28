import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    tree[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];
		parent = new int[N + 1];
		
		for(int i = 1 ; i <= N - 1 ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
            tree[s].add(e);
            tree[e].add(s);
		}
		
		bfs(1);
		
		for(int i = 2 ; i <= N ; i++) {
		    sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int num) {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(num);
	    
	    visited[num] = true;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        for(int next : tree[now]) {
	            if(!visited[next]) {
	                visited[next] = true;
	                parent[next] = now;
	                queue.add(next);
	            }
	        }
	    }
	}
}
