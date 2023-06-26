import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] dp;  // 최단 거리 배열
    static int INF = 987654321;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());    // 도시 개수
		M = Integer.parseInt(br.readLine());    // 버스 개수
		
		// 최단 거리 배열 초기화
		dp = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        dp[i][j] = (i == j) ? 0 : INF;
		    }
		}
		
		// 입력 받아 그래프 데이터 채우기
		while(M --> 0) {
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    
		    dp[s][e] = Math.min(dp[s][e], v);
		}
		
		// 플로이드-워셜 수행
		for(int K = 1 ; K <= N ; K++) {
		    for(int S = 1 ; S <= N ; S++) {
		        for(int E = 1 ; E <= N ; E++) {
		            dp[S][E] = Math.min(dp[S][E], dp[S][K] + dp[K][E]);
		        }
		    }   
		}
		
		// 출력하기
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		System.out.println(sb);
	}
}
