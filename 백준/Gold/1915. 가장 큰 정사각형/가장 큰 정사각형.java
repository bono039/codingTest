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
		
		long max = 0;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++) {
                if(DP[i][j] == 1) {
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j - 1], DP[i][j - 1]), DP[i - 1][j]) + 1;
                }
                if(max < DP[i][j]) {
                    max = DP[i][j];
                } 
            }
        }
        System.out.println(max * max);
		br.close();
	}
}