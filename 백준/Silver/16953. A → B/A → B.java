import java.util.*;
import java.io.*;

public class Main {
    static long A, B;
    static int cnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		System.out.println(BFS(A));
	}
	
	static long BFS(long n) {
	    Queue<Long> queue = new LinkedList<>();
	    queue.add(n);

	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        
	        for(int i = 0 ; i < size ; i++) {
	            long now = queue.poll();
	            
                if(now == B) {
                    return cnt + 1;
                }
                
                if(now * 2 <= B)       queue.add(now * 2);
                if(now * 10 + 1 <= B)  queue.add(now * 10 + 1); 
	        }
	        cnt++;
	    }
	    return -1;
	}
}