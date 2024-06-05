import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    
	    while(T --> 0) {
	        int N = Integer.parseInt(br.readLine());
	        int f = 0;
	        int t = 0;
	        
	        for(int i = 2 ; i <= N ; i *= 2) {
	            t += N/i;
	        }
	        for(int i = 5 ; i <= N ; i *= 5) {
	            f += N/i;
	        }
	        
	        sb.append(Math.min(f, t)).append("\n");
	    }
	    System.out.println(sb.toString());
	}
}
