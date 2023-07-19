import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];
        int[] dp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = cost[0];
        for(int i = 1 ; i < N ; i++) {
            dp[i] = cost[i];
            
            for(int j = 0 ; j < i ; j++) {
                if(cost[i] > cost[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + cost[i]);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
