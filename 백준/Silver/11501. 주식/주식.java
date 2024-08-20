import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    int T = Integer.parseInt(br.readLine());
	    for(int i = 0 ; i < T ; i++) {
	        int N = Integer.parseInt(br.readLine());
	        
	        int[] arr = new int[N];
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < N ; j++) {
	            arr[j] = Integer.parseInt(st.nextToken());
	        }
	        
	        long answer = 0;
	        long max = 0;
	        
	        for(int j = arr.length - 1 ; j >= 0 ; j--) {
	            if(arr[j] <= max)
	                answer += max - arr[j];
	            else
	                max = arr[j];
	        }
	        sb.append(answer).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
}