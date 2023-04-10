import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());

		Stack<Long> stack = new Stack<>();		
		for(int i = 0 ; i < k ; i++) {
		    long num = Long.parseLong(br.readLine());
		    
		    if(num != 0) {
		        stack.push(num);
		    } else {
		        stack.pop();
		    }
		}
		
		long sum = 0;
		for(long i : stack) {
		    sum += i;
		}
		
		System.out.println(sum);
	}
}