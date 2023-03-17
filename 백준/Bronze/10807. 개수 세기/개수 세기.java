import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
        var st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i<n ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
        int v = Integer.parseInt(br.readLine());
        
	    int cnt = 0;
	    
	    for(int i : arr) {
	        if(i == v)
	            cnt++;
	    }
	    
	    System.out.println(cnt);
	}
}