import java.util.*;
import java.io.*;

public class Main {
    public final static int MAX  = 100001;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int dp[]   = new int[k + 1];
		Arrays.fill(dp, MAX);
		dp[0] = 0;

		int coin[] = new int[n + 1];	
		for(int i = 1 ; i <= n ; i++) {
		    coin[i] = Integer.parseInt(br.readLine());
		    
		    for(int j = coin[i] ; j <= k ; j++) {
		        dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
		    }
		}		

		System.out.println(dp[k] == MAX ? -1 : dp[k]);
		br.close();
	}
}