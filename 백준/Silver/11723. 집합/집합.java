import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		while(M --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    String s = st.nextToken();
		    
		    if(s.equals("all")) {
		        list.clear();
		        for(int i = 1 ; i <= 20 ; i++) {
		            list.add(i);
		        }
		    }
		    else if(s.equals("empty")) {
		        list.clear();
		    }
		    
		    else {
		        int x = Integer.parseInt(st.nextToken());

    		    if(s.equals("add")) {
    		        if(!list.contains(x)) list.add(x);
    		        else continue;
    		    }
    		    else if(s.equals("check")) {
    		        if(list.contains(x)) sb.append(1 + "\n");
    		        else                 sb.append(0 + "\n");
    		    }
    		    else if(s.equals("remove")) {
    		        if(list.contains(x)) list.remove(Integer.valueOf(x));
    		        else continue;
    		    }
    		    else if(s.equals("toggle")) {
    		        if(list.contains(x)) list.remove(Integer.valueOf(x));
    		        else list.add(x);
    		    }
		    }
		}
		System.out.println(sb);
	}
}