import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N --> 0) {
		    char[] ch = br.readLine().toCharArray();
		    Stack<Character> stack = new Stack<>();
		    
		    for(int i = 0 ; i < ch.length ; i++) {
		        if(ch[i] == '(') {
		            stack.push('(');
		        }
		        else {
		            if(!stack.isEmpty() && stack.peek() == '(') {
		                stack.pop();
		            }
		            else {
		                stack.push(')');
		            }
		        }
		    }
		    
		    sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
		}
		
		System.out.println(sb);
	}
}
