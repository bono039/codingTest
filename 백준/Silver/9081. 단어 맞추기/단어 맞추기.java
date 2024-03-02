import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    T = Integer.parseInt(br.readLine());
	    while(T --> 0) {
	        solve(br.readLine());
	    }
	    
	    System.out.println(sb.toString());
	}
	
	private static void solve(String str) {
	    int len = str.length();
	    char[] ch = str.toCharArray();
	    
	    int idx1 = -1;
	    int idx2 = 0;
	    
	    for(int i = len - 1 ; i > 0 ; i--) {
	        if(ch[i - 1] < ch[i]) {
	            idx1 = i - 1;
	            break;
	        }
	    }
	    
	    if(idx1 == -1) {
	        sb.append(str).append("\n");
	        return;
	    }
	    
	    for(int i = len - 1 ; i >= 0 ; i--) {
	        if(ch[idx1] < ch[i]) {
	            idx2 = i;
	            break;
	        }
	    }
	    
	    char tmp = ch[idx1];
	    ch[idx1] = ch[idx2];
	    ch[idx2] = tmp;
	    
	    Arrays.sort(ch, idx1 + 1, len);
	    
	    for(char c : ch)
	        sb.append(c);
	    sb.append("\n");
	}
}
