import java.util.*;
import java.io.*;

public class Main {
    static int F,S,G,U,D;
    static int[] arr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    F = Integer.parseInt(st.nextToken());
	    S = Integer.parseInt(st.nextToken());
	    G = Integer.parseInt(st.nextToken());
	    U = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
	    
	    arr = new int[F + 1];
	    int answer = bfs();
	    
	    System.out.println(answer == -1 ? "use the stairs" : answer);
	}
	
	private static int bfs() {
	    Queue<Integer> q = new ArrayDeque<>();
	    q.add(S);
	    
	    arr[S] = 1;
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        
	        if(now == G) {
	            return arr[now] - 1;
	        }
	        
	        if(now + U <= F) {
	            if(arr[now + U] == 0) {
	                arr[now + U] = arr[now] + 1;
	                q.add(now + U);
	            }
	        }
	        if(now - D >= 1) {
	            if(arr[now - D] == 0) {
	                arr[now - D] = arr[now] + 1;
	                q.add(now - D);
	            }
	        }
	    }
	    
	    return -1;
	}
}
