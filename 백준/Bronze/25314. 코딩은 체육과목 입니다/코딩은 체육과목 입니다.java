import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
        for(int i=0 ; i < N/4 ; i++) {
            sb.append("long ");
        }
        sb.append("int");
	    
	    bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
}