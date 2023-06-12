import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int h = Integer.parseInt(st.nextToken()); 
		    int w = Integer.parseInt(st.nextToken());
		    int n = Integer.parseInt(st.nextToken());
		    
		    if(n % h == 0) {
		        sb.append((h * 100) + (n / h)).append("\n");
		    } else {
		        sb.append(((n % h) * 100) + ((n / h) + 1)).append("\n");
		    }	    
		}
		
		System.out.print(sb);
	}
}