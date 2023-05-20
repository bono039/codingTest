import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<String> stack = new Stack<>();
		
		boolean flag = true;    // **추가**
		int result = 0;
		int cnt = 1;
		
		for(int i = 0 ; i < str.length() ; i++) {
		    String s = String.valueOf(str.charAt(i));
		    
		    switch(s)  {
		        case "(" :
		            stack.push("(");
		            cnt *= 2;
		            break;
		            
		        case ")" :
		            if(stack.isEmpty() || !stack.peek().equals("(")) {
		                flag = false;   // **변경**
		                break;
		            }
		            
		            // stack.peek().equals("(") 로 하면 틀림! (반례 : [[[]]]) )
		            if(str.charAt(i - 1) == '(') {
		                result += cnt;
		            }
		            stack.pop();
		            cnt /= 2;
		            break;
		            
		        case "[" :
		            stack.push("[");
		            cnt *= 3;
		            break;
		            
		        case "]" :
		            if(stack.isEmpty() || !stack.peek().equals("[")) {
		                flag = false;   // **변경**
		                break;
		            }
		            
		            if(str.charAt(i - 1) == '[') {
		                result += cnt;
		            }
		            stack.pop();
		            cnt /= 3;
		            break;
		          
		        // ** 변경 **
		        default:
		            flag = false;
		            break;
		    }
		}
		
		System.out.println( (!flag || !stack.isEmpty()) ? 0 : result);
	}
}