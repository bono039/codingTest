import java.util.*;
import java.io.*;

public class Main {
    static String S, T;
    static boolean canChange = false;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    S = br.readLine();
	    T = br.readLine();
	    
	    System.out.println(dfs(S, T));
	}
	
	private static int dfs(String s, String t) {
	    if(s.length() == t.length()) {
	        if(s.equals(t))
	            return 1;
	        return 0;
	    }
	    
	    int ans = 0;
	    if(t.charAt(0) == 'B') {
	        StringBuilder s1 = new StringBuilder(t.substring(1));
	        String newStr = s1.reverse().toString();
	        ans += dfs(s, newStr);
	    }
	    
	    if(t.charAt(t.length() - 1) == 'A') {
	        ans += dfs(s, t.substring(0, t.length() - 1));
	    }
	    
	    return ans > 0 ? 1 : 0;
	}
}