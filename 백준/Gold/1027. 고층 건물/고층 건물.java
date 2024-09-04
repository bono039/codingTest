import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new int[N];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int ans = 0;
	    for(int i = 0 ; i < N ; i++) {
	        ans = Math.max(ans, solve(i));
	    }
	    
	    System.out.println(ans);
	}
	
	private static int solve(int idx) {
	    int cnt = 0;
	    double tmp = 0;
	    
	    for(int i = idx-1 ; i >= 0 ; i--) {
	        double slope = (double) (arr[idx] - arr[i]) / (idx - i);
	        
	        if(i == idx-1 || tmp > slope) {
	            cnt++;
	            tmp = slope;
	        }
	    }
	    
	    for(int i = idx+1 ; i < N ; i++) {
	        double slope = (double) (arr[idx] - arr[i]) / (idx - i);
	        
	        if(i == idx+1 || tmp < slope) {
	            cnt++;
	            tmp = slope;
	        }
	    }
	    
	    return cnt;
	}
}