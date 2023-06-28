import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		int backIdx = 0;
		
		while(N --> 0) {
            String[] str = br.readLine().split(" ");
            
		    switch(str[0]) {
		        case "push":
		            queue.add(Integer.parseInt(str[1]));
		            backIdx = Integer.parseInt(str[1]);
		            break;
		            
		        case "pop":
		            sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
		            break;
		            
		        case "size":
		            sb.append(queue.size()).append("\n");
		            break;
		            
		        case "empty":
		            sb.append(queue.isEmpty() ? 1 : 0).append("\n");
		            break;

		        case "front":
		            sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
		            break;
		            
		        case "back":
		            sb.append(queue.isEmpty() ? -1 : backIdx).append("\n");
		            break;
		    }
		    
		}
		System.out.println(sb);
	}
}
