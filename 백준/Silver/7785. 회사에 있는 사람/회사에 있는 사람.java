import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();

		for(int i=0 ; i < n ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");		    
		    String name = st.nextToken();
		    String isIn = st.nextToken();
		    
		    if(isIn.equals("enter")) {
		        set.add(name);
		    } else {
		        set.remove(name);
		    }
		}
		
		set.stream()
		   .sorted(Collections.reverseOrder())
		   .forEach(System.out::println);
	}
}