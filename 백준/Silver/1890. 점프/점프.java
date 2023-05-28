import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
        
		
		// 입력 받기
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    for(int j = 1 ; j <= N ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		long[][] dp  = new long[N + 1][N + 1];
		dp[1][1] = 1;
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        int next = map[i][j];
		        
		        if(i == N && j == N) continue;
		        
		        if(j + next <= N)    dp[i][j + next] += dp[i][j];
		        if(i + next <= N)    dp[i + next][j] += dp[i][j];
		    }
		}		
		
		System.out.println(dp[N][N]);
	}
}