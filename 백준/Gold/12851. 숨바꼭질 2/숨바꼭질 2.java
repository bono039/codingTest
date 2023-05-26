import java.util.*;
import java.io.*;
public class Main {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int cnt;
    static int next;
    
    static int[] time = new int[100001];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
		    System.out.println(N - K);
		    System.out.println(1);
		    return;
		}
		
		BFS();
		System.out.println(min);
		System.out.println(cnt);
	}
	
	static void BFS() {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(N);
	    time[N] = 1;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        if(min < time[now]) return;
	        
	        for(int i = 0 ; i < 3 ; i++) {
                if(i == 0)      next = now + 1;
                else if(i == 1) next = now - 1;
                else            next = now * 2;
	            
	            if(next < 0 || next > 100000) continue;
	            
	            if(next == K) {
	                min = time[now];
	                cnt++;
	            }
	            
	            if(time[next] == 0 || time[next] == time[now] + 1) {
	                queue.offer(next);
	                time[next] = time[now] + 1;
	            }
	        }
	    }
	}
}