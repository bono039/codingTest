import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
		    queue.add(i);
		}
		
		while(queue.size() > 1) {
		    if(!queue.isEmpty()) {
		       sb.append(queue.poll()).append(" "); 
		    }
		    queue.offer(queue.poll());
		}
		sb.append(queue.poll());
		System.out.println(sb);
	}
}