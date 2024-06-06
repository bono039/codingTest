import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    int[] arr = new int[N+1];
	    int sum = 0;
	    
	    for(int i = 0 ; i < N ; i++) {
	        int dist = Integer.parseInt(br.readLine());
	        arr[i] = dist;
	        sum += dist; 
	    }
	    
	    int start = 0;
	    int end = 0;
	    
	    int result = 0;
	    int now = arr[start];
	    
	    while(start <= end && end < N) {
	        int minNow = Integer.min(now, sum-now);
	        
	        result = Integer.max(result,minNow);
	        
	        if(now == minNow) {
	            end++;
	            now += arr[end];
	        }
	        else {
	            now -= arr[start];
	            start++;
	        }
	    }
	    
	    System.out.println(result);
	}
}
