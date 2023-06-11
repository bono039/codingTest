import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int cnt = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		A = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		visited = new boolean[N + 1];
		
		while(M --> 0) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
		    A[s].add(e);
		    A[e].add(s);
		}
		
        bfs(1);
        System.out.println(cnt);
	}
	
	private static void bfs(int num) {
	    visited[num] = true;
	    
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(num);
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        for(int next : A[now]) {
	            if(!visited[next]) {
	                visited[next] = true;
	                queue.add(next);
	                cnt++;
	            }
	        }
	    }
	}
}