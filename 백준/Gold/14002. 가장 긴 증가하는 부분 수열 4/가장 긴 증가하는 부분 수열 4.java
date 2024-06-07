import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A, dp;
    static String[] str;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    A = new int[N];
	    dp = new int[N];
	    str = new String[N];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	        dp[i] = 1;
	        str[i] = String.valueOf(A[i]);
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < i ; j++) {
	            if(A[j] < A[i] && (dp[j] + 1 > dp[i])) {
	                dp[i] = dp[j] + 1;
	                str[i] = str[j] + " " + A[i];
	            }
	        }
	    }
	    
	    int max = 0;
	    int idx = 0;
	    for(int i = 0 ; i < N ; i++) {
	        if(max < dp[i]) {
	            max = dp[i];
	            idx = i;
	        }
	    }
	    
	    System.out.println(max);
	    System.out.println(str[idx]);
	}
}
