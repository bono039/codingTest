import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    while(N --> 0) {
	        String[] str = br.readLine().split(" ");
	        
	        if(str[0].equals("push"))   
	            stack.push(Integer.parseInt(str[1]));
	        else if(str[0].equals("pop"))
	            sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
	        else if(str[0].equals("size"))
	            sb.append(stack.size()).append("\n");
	        else if(str[0].equals("empty"))
	            sb.append(stack.isEmpty() ? 1 : 0).append("\n");
	        else if(str[0].equals("top"))
	            sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
}
