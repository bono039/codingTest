import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[n][m];
        for(int i = 0 ; i < n ; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0 ; j < m ; j++) {
                dp[i][j] = ch[j] - '0';
            }
        }
        
        long max = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(dp[i][j] == 1 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + dp[i][j];
                }
                if(max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max * max);
    }
}
