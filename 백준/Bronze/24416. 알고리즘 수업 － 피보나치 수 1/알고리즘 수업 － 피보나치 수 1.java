import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int cnt, dpCnt = 0;
    static int[] f;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		f = new int[n+1];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(cnt + " " + dpCnt);
	}
	
	static int fib(int num) {
	    if(num == 1 || num == 2) {
	        cnt++;
	        return 1;
	    }
	    return fib(num - 1) + fib(num - 2);
	}
	
	static int fibonacci(int num) {
	    f[1] = f[2] = 1;
	    for(int i = 3 ; i <= num ; i++) {
	        f[i] = f[i - 1] + f[i - 2];
	        dpCnt++;
	    }
	    return f[num];
	}
}