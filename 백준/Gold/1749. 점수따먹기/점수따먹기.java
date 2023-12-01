import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map, dp;
    
    static long max = Integer.MIN_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 1 ; j <= M ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= M ; j++) {
		        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
		    }
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= M ; j++) {
		        for(int x = i ; x <= N ; x++) {
		            for(int y = j ; y <= M ; y++) {
		                long result = prefixSum(i, j, x, y);
		                max = Math.max(max, result);
		            }
		        }
		    }
		}
		
		System.out.println(max);
	}
	
	private static long prefixSum(int x1, int y1, int x2, int y2) {
	    return dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
	}
}
