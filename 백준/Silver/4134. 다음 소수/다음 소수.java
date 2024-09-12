import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    for(int i = 0 ; i < N ; i++) {
	        long x = Long.parseLong(br.readLine());
	        
            BigInteger pNum = new BigInteger(String.valueOf(x));
            
	        if(pNum.isProbablePrime(10)) {
	            sb.append(pNum + "\n");
	        }
	        else {
	            sb.append(pNum.nextProbablePrime() + "\n");
	        }
	    }
	    
	    System.out.println(sb.toString());
	}
}