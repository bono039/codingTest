import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        int[][] dp  = new int[15][15];
        for(int i = 0 ; i < 15 ; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for(int i = 1 ; i < 15 ; i++) {
            for(int j = 2 ; j < 15 ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }        

        while(T --> 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append("\n");
        }
        
        System.out.println(sb);
    }
}
