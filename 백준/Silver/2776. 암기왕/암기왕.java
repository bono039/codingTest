import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int x = 0 ; x < T ; x++) {
    	    int N = Integer.parseInt(br.readLine());
    	    Set<Integer> set = new HashSet<>();
    	    
    	    st = new StringTokenizer(br.readLine(), " ");
    	    for(int i = 0 ; i < N ; i++) {
    	        set.add(Integer.parseInt(st.nextToken()));
    	    }
    	    
    	    int M = Integer.parseInt(br.readLine());
    	    int[] arr = new int[M];
    	    
    	    st = new StringTokenizer(br.readLine(), " ");
    	    for(int i = 0 ; i < M ; i++) {
    	        arr[i] = Integer.parseInt(st.nextToken());
    	    }
    	    
    	    for(int i = 0 ; i < M ; i++) {
    	        if(set.contains(arr[i])) {
    	            sb.append("1" + "\n");
    	        }
    	        else {
    	            sb.append("0" + "\n");
    	        }
    	    }
	    }
	    
	    System.out.println(sb.toString());
	}
}