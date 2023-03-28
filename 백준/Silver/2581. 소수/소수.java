import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = Math.min(m,n) ; i <= Math.max(m,n) ; i++) {
		    boolean isPrime = true;
		    
		    if(i == 1) isPrime = false;
		    
		    for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
		        if(i % j == 0) {    // 소수가 아닌 경우
		            isPrime = false;
		            break;
		        }
		    }

		    // 소수인 경우		    
		    if(isPrime) {
                sum += i;
                list.add(i);		        
		    }
		}
		
		if(list.size() != 0) {
    		System.out.println(sum);
    		System.out.println(list.get(0));		    
		}
		else {
		    System.out.println(-1);
		}
	}
}