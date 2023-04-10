import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
		    String[] input = br.readLine().split(" ");
		    
		    if(input[0].equals("push")) {
		        stack.push(Integer.parseInt(input[1]));
		    }
		    else if(input[0].equals("top")) {
		        if(stack.isEmpty()) {
		            list.add(-1);
		        } else {
		            list.add(stack.peek());
		        }		        
		    }
		    else if(input[0].equals("size")) {
		        list.add(stack.size());
		    }
		    else if(input[0].equals("empty")) {
		        if(stack.isEmpty()) {
		            list.add(1);
		        } else {
		            list.add(0);
		        }
		    }
		    else if(input[0].equals("pop")) {
		        if(stack.isEmpty()) {
		            list.add(-1);
		        } else {
		            list.add(stack.pop());
		        }
		    }
		}
		
		for(int i : list) {
		    System.out.println(i);
		}
	}
}