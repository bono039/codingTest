import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());

	    for(int i=0 ; i < n ; i++) {
	        var st = new StringTokenizer(br.readLine(), " ");
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        int gcd = 1;
	        
	        // 최대공약수
    	    for(int j=1 ; j <= Math.min(a,b) ; j++) {
    	        if(a % j == 0 && b % j == 0) {
    	            gcd = j;
    	        }
    	    }
	        
	        // 최소공배수
	        System.out.println(a*b/gcd);
	    }	    
	}
}