import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    
		    if(a == 0 && b == 0 && c == 0) break;
		    
		    if(a == b && b == c && c == a)
		        sb.append("Equilateral").append("\n");
		    else if(a + b <= c || a + c <= b || b + c <= a)
		        sb.append("Invalid").append("\n");
		    else if(a == b || b == c || c == a)
		        sb.append("Isosceles").append("\n");
		    else
		    sb.append("Scalene").append("\n");
		}
		
        System.out.println(sb);
	}
}