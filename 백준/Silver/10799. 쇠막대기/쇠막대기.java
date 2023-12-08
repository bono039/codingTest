import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		
		for(int i = 0 ; i < ch.length ; i++) {
		    if(ch[i] == '(') {
		        stack.push('(');
		    }
		    else {
		        stack.pop();
		        if(ch[i - 1] == '(')
		            cnt += stack.size();
		        else
		            cnt++;
		    }
		}
		
		System.out.println(cnt);
	}
}
