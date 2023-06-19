import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    while(T --> 0) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	       
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        
	        LinkedList<int[]> queue = new LinkedList<>();
	        
	        st = new StringTokenizer(br.readLine());
	        for(int i = 0 ; i < N ; i++) {
	            queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
	        } 
	        
	        int cnt = 0;
	        
	        while(!queue.isEmpty()) {
                boolean isMax = true;
                int now[] = queue.remove();
                
                for(int i = 0 ; i < queue.size() ; i++) {
                    if(now[1] < queue.get(i)[1]) {
                        queue.offer(now);
                        
                        for(int j = 0 ; j < i ; j++) {
                            queue.offer(queue.poll());
                        }
                        
                        isMax = false;
                        break;
                    }
                }
	               
                if(isMax) {
                    cnt++;
                    if(now[0] == M) break;
                }
            }
	        sb.append(cnt).append("\n");
	    }
	    
		System.out.print(sb);
	}
}