import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
        
		dp = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 0 ; j < N ; j++) {
		        dp[i][j] = Integer.parseInt(st.nextToken());
		    }
		}

        for(int k = 0 ; k < N ; k++) {
            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(dp[i][k] == 1 && dp[k][j] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < N ; j++) {
		        sb.append(dp[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		System.out.println(sb);
	}
}
