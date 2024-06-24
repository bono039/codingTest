import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> st = new Stack<>();
		Queue<Character> q = new ArrayDeque<>();
		
	    char[] ch = br.readLine().toCharArray();
		
		boolean exists = false;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < ch.length ; i++) {
		    if(ch[i] == ' ') {
		        if(!exists) {
    		        while(!st.isEmpty()) {
    		            sb.append(st.pop());
    		        }
		        }
		        else {
		            while(!q.isEmpty()) {
		                sb.append(q.poll());
		            }
		        }
		        sb.append(" ");
		    }
		    else if(ch[i] == '<') {
		        while(!st.isEmpty()) {
		            sb.append(st.pop());
		        }
		        
    		    exists = true;
    		    q.add('<');
		    }
		    else if(ch[i] == '>') {
		        exists = false;
		        
		        while(!q.isEmpty()) {
		            sb.append(q.poll());
		        }
		        sb.append('>');
		    }
		    else {
    		    if(!exists) {
    		        st.push(ch[i]);
    		    }
    		    else {
    		        q.add(ch[i]);
    		    }
		    }
		}
		
	    while(!st.isEmpty()) {
	        sb.append(st.pop());
	    }
		
		System.out.println(sb.toString());
	}
}