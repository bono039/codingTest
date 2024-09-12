import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    for(int i = 0 ; i < N ; i++) {
	        long x = Long.parseLong(br.readLine());
            
            if(x <= 2) {
                sb.append(2).append("\n");
                continue;
            }
    
    	    while(true) {
                boolean flag = true;
                
                for(int j = 2 ; j <= (int)(Math.sqrt(x)) ; j++) {
                    if(x % j == 0) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    sb.append(x).append("\n");
                    break;
                }
                
                x++;
    	    }
	    }
	    
	    System.out.println(sb.toString());
	}
}