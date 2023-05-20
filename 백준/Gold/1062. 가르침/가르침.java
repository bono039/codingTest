import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int max = 0;
    static boolean[] visited = new boolean[26];
    static String[] words;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		words = new String[n];
		for(int i = 0 ; i < n ; i++) {
		    words[i] = br.readLine();
		    words[i] = words[i].replace("anta", "").replace("tica", "");
		}
		
		if(k < 5) {
		    System.out.println(0);
		    return;
		}
		else if(k == 26) {
		    System.out.println(n);
		    return;
		}
		
		visited = new boolean[26];
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		
		backtracking(0, 0);
		System.out.println(max);
	}
	
	public static void backtracking(int alpha, int len) {
	    if(len == k - 5) {
	        int cnt = 0;
	        
	        for(int i = 0 ; i < n ; i++) {
	            boolean isValid = true;
	            
	            for(int j = 0 ; j < words[i].length() ; j++) {
	                if(!visited[words[i].charAt(j) - 'a']) {
	                    isValid = false;
	                    break;
	                }
	            }
	            if(isValid) cnt++;
	        }
	        max = Math.max(max, cnt);
	        return;
	    }
	    
	    for(int i = alpha ; i < 26 ; i++) {
	        if(!visited[i]) {
	            visited[i] = true;
	            backtracking(i, len + 1);
	            visited[i] = false;
	        }
	    }
	}
}