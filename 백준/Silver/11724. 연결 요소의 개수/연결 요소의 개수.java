import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    A = new ArrayList[N + 1];
	    for(int i = 1 ; i <= N ; i++) {
	        A[i] = new ArrayList<>();
	    }
	    
	    visited = new boolean[N + 1];
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int u = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        
	        A[u].add(v);
	        A[v].add(u);
	    }
	    
	    int cnt = 0;
	    for(int i = 1 ; i <= N ; i++) {
	        if(!visited[i]) {
	            cnt++;
	            dfs(i);
	        }
	    }
	    
		System.out.println(cnt);
	}
	
	private static void dfs(int num) {
	    if(visited[num]) return;
	    
	    visited[num] = true;
	    for(int next : A[num]) {
	        if(!visited[next]) {
	            dfs(next);
	        }
	    }
	}
}