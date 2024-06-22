import java.util.*;
import java.io.*;

public class Main {
    static char[] A,B,C;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    A = br.readLine().toCharArray();
	    B = br.readLine().toCharArray();
	    C = br.readLine().toCharArray();
	    
	    System.out.println(getLCS());
	}
	
	private static int getLCS() {
	    int[][][] dp = new int[A.length + 1][B.length + 1][C.length + 1];
	    
	    for(int i = 1 ; i <= A.length; i++) {
	        for(int j = 1 ; j <= B.length ; j++) {
	            for(int k = 1 ; k <= C.length ; k++) {
	                if(A[i-1] == B[j-1] && B[j-1] == C[k-1])
	                    dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
	                else
	                    dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
	            }
	        }
	    }
	    
	    return dp[A.length][B.length][C.length];
	}
}