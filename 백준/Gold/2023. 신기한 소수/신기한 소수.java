import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    
	    // 2,3,5,7
	    DFS(2, 1);
	    DFS(3, 1);
	    DFS(5, 1);
	    DFS(7, 1);  
	}
	
    // DFS 구현	
	static void DFS(int num, int digit) {
	    if(digit == N) {  // 자릿수 == N
	        if(isPrime(num)) {
	            System.out.println(num);
	        }
	        return;
	    }
	    
	    for(int i = 1 ; i < 10 ; i++) {
	        if(i % 2 == 0) {
	            continue;
	        }
	        
	        if(isPrime(num * 10 + i)) {
	            DFS(num * 10 + i, digit + 1);
	        }
	    }
	}
	
	// 소수 구하기
	static boolean isPrime(int n) {
	    for(int i = 2 ; i <= (int)Math.sqrt(n) ; i++) {
	        if(n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}
