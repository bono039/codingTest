import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] A;
    static int[]     parent;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		A = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		parent = new int[N + 1];    // 101?
		for(int i = 1 ; i <= N ; i++) {
		    parent[i] = i;
		}
		
		visited = new boolean[N + 1];
		
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    A[a].add(b);
		    A[b].add(a);
		}
		
		BFS(1);
		
		int cnt = 0;
		for(int i : parent) {
		    if(i == 1) {
		        cnt++;
		    }
		}
		System.out.println(cnt - 1);
	}
	
	static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b) parent[b] = a;
	}
	static int find(int n) {
	    if(n == parent[n]) return n;
	    return parent[n] = find(parent[n]);
	}
	
	static void BFS(int n) {
	    visited[n] = true;
	    
	    Queue<Integer> queue = new LinkedList<>();
	    queue.offer(n);
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        for(int next : A[now]) {
	            if(!visited[next]) {
	                visited[next] = true;
	                union(now, next);
	                queue.add(next);
	            }
	        }
	    }
	}
}