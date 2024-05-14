import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int INF = 10000001;
    static int[][] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        dp[i][j] = (i == j) ? 0 : INF;
		    }
		}

		while(M --> 0) {
		     st = new StringTokenizer(br.readLine(), " ");
		     int a = Integer.parseInt(st.nextToken());
		     int b = Integer.parseInt(st.nextToken());
		     
		     dp[a][b] = dp[b][a] = 1;
		}
		
		for(int k = 1 ;  k <= N ; k++) {
		    for(int i = 1 ; i <= N ; i++) {
		        for(int j = 1 ; j <= N ; j++) {
		            if(dp[i][j] > dp[i][k] + dp[k][j]) {
		                dp[i][j] = dp[i][k] + dp[k][j];
		            }
		        }
		    }
		}
		
		int min = Integer.MAX_VALUE;
		int answer = -1;
		
		for(int i = 1 ; i <= N ; i++) {
		    int tmp = 0;
		    for(int j = 1 ; j <= N ; j++) {
		        tmp += dp[i][j];
		    }
		    
		    if(min > tmp) {
		        min = tmp;
		        answer = i;
		    }
		}
		System.out.println(answer);
	}
}
