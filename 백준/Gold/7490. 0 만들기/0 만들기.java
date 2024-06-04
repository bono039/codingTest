import java.util.*;
import java.io.*;

public class Main {
    static int T, N;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    
	    while(T --> 0) {
	        N = Integer.parseInt(br.readLine());
    	    dfs(N, 1, 1, 1, 0, "1");
	        sb.append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
	
	private static void dfs(int max, int now, int num, int sign, int sum, String str) {
	    if(max == now) {
	        sum = sum + (num*sign);
	        
	        if(sum == 0)
	            sb.append(str).append("\n");
	        return;
	    }
	    
	    dfs(max, now+1, num*10 + (now+1), sign, sum, str + " " + String.valueOf(now+1));
	    dfs(max, now+1, now+1,  1, sum + (num*sign), str + "+" + String.valueOf(now+1));
	    dfs(max, now+1, now+1, -1, sum + (num*sign), str + "-" + String.valueOf(now+1));
	}
}
