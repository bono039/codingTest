import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		for(int i = 0 ; i < n ; i++) {
		    A[i] = Integer.parseInt(br.readLine());
		}
		
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        boolean result = true;
        
		for(int i = 0 ; i < n ; i++) {
		    int cur = A[i];
		    
		    if(cur >= num) {    
		        while(cur >= num) {
		            stack.push(num++);
		            sb.append("+\n");
		        }
		        stack.pop();
		        sb.append("-\n");
		    }
		    else {
		        int now = stack.pop();
		        
		        if(now > cur) {
		            System.out.println("NO");
		            result = false;
		            break;
		        }
		        else {
		            sb.append("-\n");
		        }
		    }
		}
		
		if(result) System.out.println(sb.toString());
	}
}