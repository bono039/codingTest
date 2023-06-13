import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(A);
        
        int[] dp = new int[N + 1];
        dp[1] = A[1];
        
        int total = dp[1];
        for(int i = 2 ;  i <= N ; i++) {
            dp[i] = dp[i-1] + A[i];
            total += dp[i];
        }
        System.out.println(total);
	}
}