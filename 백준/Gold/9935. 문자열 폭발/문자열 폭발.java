import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine();
	    String bomb = br.readLine();
	    
	    Stack<Character> stack = new Stack<>();
	   
	    for(int i = 0 ; i < str.length() ; i++) {
	        stack.push(str.charAt(i));
	        
	        if(stack.size() >= bomb.length()) {
	            boolean isSame = true;
	            
	            for(int j = 0 ; j < bomb.length() ; j++) {
	                char ch1 = stack.get(stack.size() - bomb.length() + j);
	                char ch2 = bomb.charAt(j);
	                
	                if(ch1 != ch2) {
	                    isSame = false;
	                    break;
	                }
	            }
	            
	            if(isSame) {
	                for(int j = 0 ; j < bomb.length() ; j++)
	                    stack.pop();
	            }
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(char ch : stack)
	        sb.append(ch);
	    
	    System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}
}
