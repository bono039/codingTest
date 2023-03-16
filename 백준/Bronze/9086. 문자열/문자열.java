import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
        StringBuilder sb;
	    int num = Integer.parseInt(br.readLine());
	    
	    for(int i=0 ; i < num ; i++) {
            sb = new StringBuilder();
	        String str = br.readLine();
	        
	        if(str.length() == 1) {
	            sb.append(str);
	            sb.append(str);
	        }
	        else {
	            sb.append(str.charAt(0));
	            sb.append(str.charAt(str.length() - 1));
	        }
	        
	        bw.write(sb.toString()+"\n"); 
	    }
	    
	    bw.flush();
	}
}