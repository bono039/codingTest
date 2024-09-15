import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine()) -1;
	    int dasom = Integer.parseInt(br.readLine());
	    
	    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	    for(int i = 0 ; i < N ; i++) {
	        pq.add(Integer.parseInt(br.readLine()));
	    }
	    
	    int answer = 0;
	    while(!pq.isEmpty() && pq.peek() >= dasom) {
	        dasom++;
	        pq.add(pq.poll() - 1);
	        answer++;
	    }
	    
	    System.out.println(answer);
	}
}