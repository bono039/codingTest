import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
		    String str = br.readLine();
		    
		    sb.append(solve(str) ? "YES" : "NO");
		    sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean solve(String str) {
    	Stack<Character> stack = new Stack<>();
	    char[] ch = str.toCharArray();
	    
	    for(int i = 0 ; i < ch.length ; i++) {
	        if(ch[i] == '(') {
	            stack.push('(');
	        }
	        else {
	            if(!stack.isEmpty() && stack.peek() == '(') {
	                stack.pop();
	            }
	            else {
	                stack.push(ch[i]);
	            }
	        }
	    }
	    
	    if(stack.isEmpty())
	        return true;
	    return false;
	}
}
