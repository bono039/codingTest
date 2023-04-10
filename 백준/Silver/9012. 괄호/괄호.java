import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
	    String[] arr = new String[T];
	    
		for(int i = 0 ; i < T ; i++) {
		    Stack<String> stack = new Stack<>();
		    
		    String[] ss = br.readLine().split("");
		    
		    for(int j = 0 ; j < ss.length ; j++) {
		        if(ss[j].equals("(")) {
		            stack.push("(");
		        }
		        else {
		            if(stack.isEmpty()) {
		                stack.add(")");
		            }
		            else if(!stack.isEmpty() && stack.peek().equals("(")){
		                stack.pop();
		            }
		        }
		    }
		    
		    arr[i] = stack.isEmpty() ? "YES" : "NO";
		}
		
		for(String result : arr) {
		    System.out.println(result);
		}
	}
}