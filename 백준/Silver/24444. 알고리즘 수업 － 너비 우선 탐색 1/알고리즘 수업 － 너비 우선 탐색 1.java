import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] A;
    static int[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    A  = new ArrayList[N + 1];
	    for(int i = 1 ; i <= N ; i++) {
	        A[i] = new ArrayList<>();
	    }
	    visited = new int[N + 1];
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	    
    	    int u = Integer.parseInt(st.nextToken());
    	    int v = Integer.parseInt(st.nextToken());
    	    
    	    A[u].add(v);
    	    A[v].add(u);
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        Collections.sort(A[i]);
	    }
	    
		bfs(R);
		
		for(int i = 1 ; i <= N ; i++) {
		    System.out.println(visited[i]);
		}
	}
	
	private static void bfs(int x) {
	    Queue<Integer> q = new LinkedList<>();
	    int cnt = 1;
	    
	    q.offer(x);
	    visited[x] = cnt++;
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        
	        for(int next : A[now]) {
	            if(visited[next] != 0)   continue;
	            
	            q.offer(next);
	            visited[next] = cnt++;
	        }
	    }
	}
}
