import java.util.*;
import java.io.*;

public class Main {
    static int n,w,L;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    n = Integer.parseInt(st.nextToken());
	    w = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    
	    Queue<Integer> trucks = new LinkedList<>();
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= n ; i++) {
	        trucks.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    int time = 0;
        int sum = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < w;  i++)    q.add(0);
        
        while(!q.isEmpty()) {
            time++;
            sum -= q.poll();
            
            if(!trucks.isEmpty()) {
                if(trucks.peek() + sum <= L) {
                    sum += trucks.peek();
                    q.add(trucks.poll());
                }
                else {
                    q.add(0);
                }
            }
        }
        
        System.out.println(time);
	}
}
