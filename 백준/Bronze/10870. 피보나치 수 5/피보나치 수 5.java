import java.util.*;
import java.io.*;

public class Main {
	public static int fib(int n) {
	    if(n == 0 || n == 1)
	        return n;
	    else
	        return fib(n-1) + fib(n-2);
	} 
	
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));	    
	    int n = Integer.parseInt(br.readLine());
	    System.out.println(fib(n));	    
	}
}