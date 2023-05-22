import java.util.*;
import java.io.*;

public class Main {
    static int[] pi;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String P = br.readLine();
		
		makePi(P);
		
		System.out.println(KMP(S, P));
	}
	
	public static void makePi(String pattern) {
	    pi = new int[pattern.length()];
	    
	    int idx = 0;
	    for(int i = 1 ; i < pattern.length() ; i++) {
	        while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
	            idx = pi[idx - 1];
	        }
	        
	        if(pattern.charAt(i) == pattern.charAt(idx)) {
	            idx++;
	            pi[i] = idx;
	        }
	    }
	}
	

	public static int KMP(String str, String pattern) {
	    int idx = 0;
	    
	    for(int i = 0 ; i < str.length() ; i++) {
	        while(idx > 0 && str.charAt(i) != pattern.charAt(idx)) {
	            idx = pi[idx - 1];
	        }
	        
	        if(str.charAt(i) == pattern.charAt(idx)) {
	            if(idx == pattern.length() - 1) {
	                idx = pi[idx];
	                return 1;
	            }
	            else {
	                idx++;
	            }
	        }
	    }
	    return 0;
	}
}