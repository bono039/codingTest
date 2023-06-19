import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0 ; i < 3 ; i++) {
	        String[] str = br.readLine().split(" ");
	        int zero = 0;
	        
	        for(int j = 0 ; j < str.length ; j++) {
	            if(str[j].equals("0")) {
	                zero++;
	            }
	        }
	        
	        if(zero == 0)      sb.append("E").append("\n");
	        else if(zero == 1) sb.append("A").append("\n");
	        else if(zero == 2) sb.append("B").append("\n");
	        else if(zero == 3) sb.append("C").append("\n");
	        else if(zero == 4) sb.append("D").append("\n");
	        
	    }
		System.out.println(sb);
	}
}