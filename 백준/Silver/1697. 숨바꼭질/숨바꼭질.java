import java.util.*;
import java.io.*;
public class Main {
    static int N, K;
    static int[] arr = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int next;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
		    System.out.println(N - K);
		    return;
		}
		
		BFS();
		System.out.println(minTime);
	}
	
	static void BFS() {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(N);
	    arr[N] = 1;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        if(minTime < arr[now]) return;
	        
	        for(int d = 0 ; d < 3; d++) {
	            if(d == 0)      next = now + 1;
	            else if(d == 1) next = now - 1;
	            else            next = now * 2;
	            
	            if(next < 0 || next > 100000) continue;
	            
	            if(next == K) {
	                minTime = arr[now];
	                return;
	            }
	            
	            if(arr[next] == 0 || arr[next] == arr[now] + 1) {
	                queue.add(next);
	                arr[next] = arr[now] + 1;
	            }
	        }
	    }
	}
}