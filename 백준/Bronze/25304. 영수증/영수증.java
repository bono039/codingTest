import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st;
	    
	    int X   = Integer.parseInt(br.readLine());
	    int N = Integer.parseInt(br.readLine());
	    
	    int total = 0;
	    for(int i=0; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");   // 한 글자씩
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        total += a * b;
	    }
	    
	    if(total == X) bw.write("Yes");
	    else           bw.write("No");
	    
	    bw.flush();
	    bw.close();
	}
}