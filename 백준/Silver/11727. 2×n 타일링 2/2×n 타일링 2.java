import java.util.*;
import java.io.*;

public class Main {
    static int mod = 10007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
        
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % mod;
        }
        System.out.println(dp[n]);
    }
}