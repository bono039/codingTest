import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
		while(true) {
		    String str = br.readLine().toLowerCase();
		    
		    if(str.equals("#")) break;
		    
            int cnt = 0;		    
		    for(int i = 0 ; i < str.length() ; i++) {
		        char ch = str.charAt(i);
		        
		        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
		            cnt++;
		    }		    
		    sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
