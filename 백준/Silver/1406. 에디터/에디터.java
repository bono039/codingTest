import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> lStack = new Stack<>();
		Stack<Character> rStack = new Stack<>();
		
		for(int i = 0 ; i < str.length() ; i++) {
		    lStack.push(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M --> 0) {
		    String cmd = br.readLine();
		    switch(cmd.charAt(0)) {
		        case 'L':
		            if(lStack.isEmpty()) break;
		            
		            rStack.push(lStack.pop());
		            break;
		            
		        case 'D':
		            if(rStack.isEmpty()) break;
		            
		            lStack.push(rStack.pop());
		            break;
		        
		        case 'B':
		            if(lStack.isEmpty()) break;
		            lStack.pop();
		            break;
		            
		        case 'P':
		            lStack.push(cmd.charAt(2));
		            break;
		    }
		}
		
		while(!lStack.isEmpty()) {
		    rStack.push(lStack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!rStack.isEmpty()) {
		    sb.append(rStack.pop());
		}
		
		System.out.println(sb);
	}
}
