import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int[] parent = new int[100001];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
 
	    BFS();
	    
	    Stack<Integer> stack = new Stack<>();
	    stack.push(K);
	    int idx = K;
	    
	    while(idx != N) {
	        stack.push(parent[idx]);
	        idx = parent[idx];
	    }
	    
	    sb.append(time[K] - 1 + "\n");
	    while(!stack.isEmpty()) {
	        sb.append(stack.pop() + " ");
	    }
        
        System.out.println(sb.toString());	   
	}
	
	static void BFS() {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(N);
	    time[N] = 1;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        if(now == K) return;
	        
	        for(int d = 0 ; d < 3 ; d++) {
	            int next;
	            
	            if(d == 0)      next = now + 1;
	            else if(d == 1) next = now - 1;
	            else            next = now * 2;
	            
	            if(next < 0 || next > 100000) continue;
	            
	            if(time[next] == 0) {
	                queue.add(next);
	                time[next] = time[now] + 1;
	                parent[next] = now;
	            }
	        }
	    }
	}
}