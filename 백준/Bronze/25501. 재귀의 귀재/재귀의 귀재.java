import java.util.*;
import java.io.*;

public class Main {
    static int cnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for(int i=0 ; i < n ; i++) {
		    cnt = 0;
		    
		    arr[i] = br.readLine();
		    
		    System.out.println(isPalindrome(arr[i]) + " " + cnt);
		}
		
		
	}
	
	public static int recursion(String s, int l, int r) {
	    cnt++;
        
	    if(l >= r)                          return 1;
	    else if(s.charAt(l) != s.charAt(r)) return 0;
	    else                                return recursion(s, l+1, r-1);
	}
	public static int isPalindrome(String s) {
	    return recursion(s, 0, s.length() - 1);
	}
}