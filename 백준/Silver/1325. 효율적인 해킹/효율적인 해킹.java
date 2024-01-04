import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] A;
    static boolean[] visited;
    
    static int maxDepth = -1;
    static int[] cntArr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    A = new ArrayList[N + 1];
	    for(int i = 1 ; i <= N ; i++)   A[i] = new ArrayList<>();
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        A[a].add(b);
	    }
	    
	    cntArr = new int[N + 1];
	    
	    for(int i = 1 ; i <= N ; i++) {
	        visited = new boolean[N + 1];
	        bfs(i);
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        if(cntArr[i] > maxDepth) {
	            maxDepth = cntArr[i];
	        }
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        if(maxDepth == cntArr[i]) {
	            System.out.print(i + " ");
	        }
	    }
	}
	
	private static void bfs(int num) {
	    Queue<Integer> q = new ArrayDeque<>();
	    q.add(num);
	    
	    visited[num] = true;
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        
	        for(int next : A[now]) {
	            if(!visited[next]) {
	                q.add(next);
	                visited[next] = true;
	                cntArr[next]++;
	            }
	        }
	    }
	}
}
