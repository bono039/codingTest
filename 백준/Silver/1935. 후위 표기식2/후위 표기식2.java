import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    String str = br.readLine();
	    
	    double[] alphabet = new double[N];
	    for(int i = 0 ; i < N ; i++) {
	        alphabet[i] = Double.parseDouble(br.readLine());
	    }
	    
	    Stack<Double> stack = new Stack<>();
	    double result = 0;
	    
	    for(int i = 0 ; i < str.length() ; i++) {
	        if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
	            stack.push(alphabet[str.charAt(i) - 'A']);
	        }
	        else {
                double n1 = stack.pop();
                double n2 = stack.pop();
                double n3 = 0.0;
                
                switch(str.charAt(i)) {
                    case '+' :
                        n3 = n2 + n1;
                        break;
                    case '-' :
                        n3 = n2 - n1;
                        break;
                    case '*' :
                        n3 = n2 * n1;
                        break;
                    case '/' :
                        n3 = n2 / n1;
                        break;
	            }
	            stack.push(n3);
	        }
	    }
	    
	    System.out.printf("%.2f", stack.pop());
	}
}