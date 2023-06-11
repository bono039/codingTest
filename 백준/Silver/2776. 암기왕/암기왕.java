import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
		    Set<Integer> set = new HashSet<>();
		    StringBuilder sb = new StringBuilder();
		    
		    int n1 = Integer.parseInt(br.readLine());
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    while(n1 --> 0) {
    		    set.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		int n2 = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine()," ");
		    while(n2 --> 0) {
		        int num = Integer.parseInt(st.nextToken());
		        
    		    if(set.contains(num)) {
		            sb.append(1).append("\n");
    		    } else {
    		        sb.append(0).append("\n");
    		    }
    		}    		
    		
    		System.out.print(sb.toString());
		}	
	}
}