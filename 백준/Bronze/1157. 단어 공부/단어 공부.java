import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cnt = new int[26];		
        String str = br.readLine().toUpperCase();
		
		int max = -1;
		char ch = '?';
		
		for(int i=0 ; i < str.length() ; i++) {
		    char c = str.charAt(i);
		    
		    cnt[c - 'A']++;
		    
		    if(max < cnt[c - 65]) {
		        max = cnt[c - 65];
		        ch = str.charAt(i);
		    }
		    else if(max == cnt[c - 65]) {
		        ch = '?';
		    }	    
		}
		
		System.out.println(ch);
	}
}