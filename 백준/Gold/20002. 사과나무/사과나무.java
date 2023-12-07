import java.util.*;
import java.io.*;

public class Main {
    static long max = Integer.MIN_VALUE;
    
    static int N;
    static int[][] board, dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 1 ; j <= N ; j++) {
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}

		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
		    }
		}
		
		for(int x1 = 1 ; x1 <= N ; x1++) {
		    for(int y1 = 1 ; y1 <= N ; y1++) {
		        for(int x2 = x1 ; x2 <= N ; x2++) {
		            for(int y2 = y1 ; y2 <= N ; y2++) {
		                if(x2 - x1 != y2 - y1)  continue;
		                
		                long ans = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
		                max = Math.max(max, ans);
		            }
		        }
		    }
		}
		
		System.out.println(max);
	}
}
