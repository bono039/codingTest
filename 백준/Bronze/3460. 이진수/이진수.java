import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
		    int n = Integer.parseInt(br.readLine());
		    String str = Integer.toBinaryString(n);
		    
		    StringBuilder sb = new StringBuilder();
		    for(int j = str.length() - 1 ; j >= 0  ; j--) {
		        if(str.charAt(j) == '1') {
		            sb.append(str.length() - 1 - j).append(" ");
		        }
		    }
		    System.out.println(sb.toString());
		}
	}
}