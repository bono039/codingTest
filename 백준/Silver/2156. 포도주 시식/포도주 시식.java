import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n + 1];
        dp[1] = A[1];
        
        if(n >= 2) {
            dp[2] = A[1] + A[2];
        }
        
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i -2] + A[i], dp[i - 3] + A[i -1] + A[i]));
        }
		System.out.println(dp[n]);
    }
}