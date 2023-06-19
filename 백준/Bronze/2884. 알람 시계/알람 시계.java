import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ")	    ;
        
        int H = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int time = 0;
	    if(H == 0) {
	        H = 24;
	    }
	    time = 60 * H + M - 45;
		System.out.println(time / 60 % 24 + " " + time % 60);
	}
}