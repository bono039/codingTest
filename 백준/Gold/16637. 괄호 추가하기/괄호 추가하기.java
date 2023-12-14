import java.util.*;
import java.io.*;

public class Main {
    
    static int ans = Integer.MIN_VALUE;
    static List<Character> ops = new LinkedList<>();
    static List<Integer> nums = new LinkedList<>();
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		for(int i = 0 ; i < N ; i++) {
		    char c = input.charAt(i);
		    
		    if(c == '+' || c == '-' || c == '*') {
		        ops.add(c);
		        continue;
		    }
		    
		    nums.add(c - '0');
		}
		
		dfs(nums.get(0), 0);
		System.out.println(ans);
	}
	
	private static int calc(char op, int n1, int n2) {
	    if(op == '+')
	        return n1 + n2;
	    else if(op == '-')
	        return n1 - n2;
	    else if(op == '*')
	        return n1 * n2;
	        
	    return -1;
	}
	
	private static void dfs(int result, int depth) {
	    if(depth >= ops.size()) {
	        ans = Math.max(ans, result);
	        return;
	    }
	    
	    int res1 = calc(ops.get(depth), result, nums.get(depth + 1));
	    dfs(res1, depth + 1);
	    
	    if(depth + 1 < ops.size()) {
	        int res2 = calc(ops.get(depth + 1), nums.get(depth + 1), nums.get(depth + 2));
	        dfs(calc(ops.get(depth), result, res2), depth + 2);
	    }
	}
}
