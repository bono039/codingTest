import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char[] ch = br.readLine().toCharArray();
	    Stack<Character> stack = new Stack<>();
	    
	    int result = 0;
	    int cnt = 1;
	    
	    for(int i = 0 ; i < ch.length ; i++) {
	        if(ch[i] == '(') {
	            stack.push('(');
	            cnt *= 2;
	        }
	        else if(ch[i] == ')') {
                if(stack.isEmpty()) {
                    result = 0;
                    break;
                }
                
                char beforeChar = stack.pop();
                if(beforeChar != '(') {
                    result = 0;
                    break;
                }
                else {
                    if(ch[i - 1] == '(') {
                        result += cnt;
                    }
                    cnt /= 2;
                }	            
	        }
	        else if(ch[i] == '[') {
	            stack.push('[');
	            cnt *= 3;
	        }
	        else if(ch[i] == ']') {
                if(stack.isEmpty()) {
                    result = 0;
                    break;
                }
                
                char beforeChar = stack.pop();
                if(beforeChar != '[') {
                    result = 0;
                    break;
                }
                else {
                    if(ch[i - 1] == '[') {
                        result += cnt;
                    }
                    cnt /= 3;
                }   
	        }
	    }
	    
	    System.out.println(stack.isEmpty() ? result : 0);
	}
}
