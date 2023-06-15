import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static ArrayList<Node>[] A;
    static boolean[] visited;

    static int[] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		
		A = new ArrayList[V + 1];
		for(int i = 1 ; i <= V ; i++) {
		    A[i] = new ArrayList<Node>();
		}
		
		for(int i = 1 ; i <= V ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    
		    int s = Integer.parseInt(st.nextToken());
		    
		    while(true) {
		        int e = Integer.parseInt(st.nextToken());
		        if(e == -1) break;
		        
                int v = Integer.parseInt(st.nextToken());
		        A[s].add(new Node(e, v));
		    }
		}
		
		visited = new boolean[V + 1];
		dp = new int[V + 1];
		bfs(1);
		
		int max = 1;
		for(int i = 2 ; i <= V ; i++) {
		    if(dp[max] < dp[i]) {
		        max = i;
		    }
		}
		
		visited = new boolean[V + 1];
		dp = new int[V + 1];
		bfs(max);
		
		Arrays.sort(dp);
		System.out.println(dp[V]);
	}
	
	private static void bfs(int num) {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(num);
	    visited[num] = true;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        for(Node next : A[now]) {
	            if(!visited[next.idx]) {
	                visited[next.idx] = true;
	                queue.add(next.idx);
	                dp[next.idx] = dp[now] + next.val;
	            }
	        }
	    }
	}
}

class Node {
    int idx;
    int val;
    
    Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}