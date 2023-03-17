import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine(), " ");
	    
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i < n ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
        
		Arrays.sort(arr);
		
		System.out.println(arr[n-k]);
	}
}