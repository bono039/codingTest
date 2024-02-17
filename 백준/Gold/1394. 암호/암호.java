import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 900528;
    
    static String words, pwd;
    static int[] arr = new int[200];
    static int ans = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    words = br.readLine();
	    pwd = br.readLine();
	    
	    for(int i = 0 ; i < words.length() ; i++) {
	        int idx = words.charAt(i) - '!';
	        
	        if(arr[idx] == 0)
	            arr[idx] = i + 1;
	    }
	    
	    for(int i = 0 ; i < pwd.length() ; i++) {
	        int idx = pwd.charAt(i) - '!';
	        
	        ans *= words.length();
	        ans += arr[idx];
	        ans %= MOD;
	    }
	    
	    System.out.println(ans);
	}
	
}
