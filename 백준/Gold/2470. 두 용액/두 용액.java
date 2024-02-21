import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    long[] A = new long[N];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        A[i] = Long.parseLong(st.nextToken());
	    }
	    Arrays.sort(A);

	    long gap = Integer.MAX_VALUE;
	    long ans1 = 0;
	    long ans2 = 0;
	    
	    int s = 0;
	    int e = N - 1;
	    
	    while(s < e) {
	        long sum = A[s] + A[e];
	        long absSum = Math.abs(sum);
	        
	        if(absSum < gap) {
	            gap = absSum;
	            ans1 = A[s];
	            ans2 = A[e];
	        }
	        
	        if(sum < 0) s++;
	        else        e--;
	    }
	    
	    System.out.println(ans1 + " " + ans2);
	}
}
