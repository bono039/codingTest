import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    String str = br.readLine();
	    boolean check = false;
	    
	    Stack<Character> stack = new Stack<>();
	    
	    for(int i = 0 ; i < str.length() ; i++) {
	        if(str.charAt(i) == '<') {
	            print(stack);
	            check = true;
	            System.out.print(str.charAt(i));
	        }
	        else if(str.charAt(i) == '>') {
	            check = false;
	            System.out.print(str.charAt(i));
	        }
	        else if(check) {
	            System.out.print(str.charAt(i));
	        }
	        else {
	            if(str.charAt(i) == ' ') {
	                print(stack);
	                System.out.print(str.charAt(i));
	            }
	            else {
	                stack.push(str.charAt(i));
	            }
	        }
	    }
	    
	    print(stack);
	}
	
	private static void print(Stack st) {
	    while(!st.isEmpty()) {
	        System.out.print(st.pop());
	    }
	}
}
