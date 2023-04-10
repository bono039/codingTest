import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int len = S.length();
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0 ; i < len ; i++) {
		    for(int j = i + 1 ; j <= len ; j++) {
		        String str = S.substring(i, j);
		        
		        if(!set.contains(str)) {
		            set.add(str);	
		        }	            
		    }
		}
				
		System.out.println(set.size());
	}
}