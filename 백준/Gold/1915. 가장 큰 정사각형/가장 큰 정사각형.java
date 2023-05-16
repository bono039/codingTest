import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[][] DP = new long[n + 1][m + 1];
		for(int i = 1 ; i <= n ; i++) {
		    String[] str = br.readLine().split("");
		    for(int j = 1 ; j <= m ; j++) {
		        DP[i][j] = Long.parseLong(str[j - 1]);
		    }
		}
		
		long len = 0;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++) {
                // 현재 자리의 원래 값이 1이라면,
                // 이 위치의 위.왼.대각선 왼쪽 위 값 中 가장 작은 값 + 1
                if(DP[i][j] == 1) {
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j - 1], DP[i][j - 1]), DP[i - 1][j]) + 1;
                    len = Math.max(DP[i][j], len);  
                }
            }
        }
        System.out.println(len * len);
		br.close();
	}
}