import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
        
		for(int i = 1 ; i <= N ; i++) {
    		if(i == 1 || i == 2 || i == 3) {
    		    dp[i] = i;
    		} else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
		}
		
		System.out.println(dp[N]);
    }
}