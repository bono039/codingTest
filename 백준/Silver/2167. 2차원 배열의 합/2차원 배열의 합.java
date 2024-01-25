import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] arr, dp;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    arr = new int[N + 1][M + 1];
	    for(int i = 1 ; i <= N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            arr[i][j + 1] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    dp = new int[N + 1][M + 1];
	    dp[1][1] = arr[1][1];
	    for(int i = 2 ; i <= N ; i++) dp[i][1] = dp[i-1][1] + arr[i][1];
	    for(int j = 2 ; j <= M ; j++) dp[1][j] = dp[1][j - 1] + arr[1][j];
	    
	    for(int i = 2 ; i <= N ; i++) {
	        for(int j = 2 ; j <= M ; j++) {
	            dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
	        }
	    }
	    
	    K = Integer.parseInt(br.readLine());
	    while(K --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int i = Integer.parseInt(st.nextToken());
	        int j = Integer.parseInt(st.nextToken());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        if(i == x && j == y)
	            sb.append(arr[i][j] + "\n");
	        else
	            sb.append(dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1] + "\n");
	    }
	    
	    System.out.println(sb);
	}
}
