import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] dp = new long[N];
        dp[0] = A[0];
        
        long max = A[0];
        for(int i = 1 ; i < N ; i++) {
            dp[i] = Math.max(dp[i-1] + A[i], A[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
