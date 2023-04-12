import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
		    String s = br.readLine();
		    
		    if(s == null || s.isEmpty() || s.equals(".")) break;
		    
		    s = s.replaceAll("[a-zA-Z]","").replaceAll(" ", "");
		    
		    //System.out.println(s);
		    
		    Stack<Character> stack = new Stack<>();
		    boolean isValid = true;
		    
		    for(int i = 0 ; i < s.length();i++) {
		        char c = s.charAt(i);
		        
		        if(c == '(' || c == '[') {
		            stack.push(c);
		        }
		        else if(c == ')' || c == ']') {
		            if(stack.isEmpty()) {
		                isValid = false;
		                break;
		            }
		            else {
		                char top = stack.pop();
		                if((c == ')' && top != '(') || (c == ']' && top != '[')) {
		                    isValid = false;
		                    break;
		                }
		            }
		        }
		    }
		    
		    if(!stack.isEmpty()) isValid = false;
		    
		    System.out.println(isValid ? "yes" : "no");
		}
	}
}