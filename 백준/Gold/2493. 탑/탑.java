import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    Stack<int[]> stack = new Stack<>();
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1; i <= N ; i++) {
	        int top = Integer.parseInt(st.nextToken());
	        
	        while(!stack.isEmpty()) {
	            if(stack.peek()[1] >= top) {
	                sb.append(stack.peek()[0] + " ");
	                break;
	            }
	            stack.pop();
	        }
	        
	        if(stack.isEmpty()) {
	            sb.append("0 ");
	        }
	        
	        stack.push(new int[] {i, top});
	    }
	    
	    System.out.println(sb.toString());
	}
}