import java.util.*;
import java.io.*;

public class Main {   
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i = 4 ; i <= N ; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
		
		System.out.println(dp[N]);
    }
}