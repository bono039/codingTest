import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static long[][] dp;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    board = new int[N][N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < N ; j++) {
	            board[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    dp = new long[N][N];
	    dp[0][0] = 1;
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(i == N-1 && j == N-1)    continue;
	            
	            int val = board[i][j];
	            
                if(j + val < N)
                    dp[i][j + val] += dp[i][j];
                
                if(i + val < N)
                    dp[i + val][j] += dp[i][j];
	        }
	    }
	    
	    System.out.println(dp[N-1][N-1]);
	}
}
