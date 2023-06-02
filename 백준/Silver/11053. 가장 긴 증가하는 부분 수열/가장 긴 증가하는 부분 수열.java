import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N + 1];
        int[] dp = new int[N + 1];  // LIS 저장 배열
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                if(seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        
        int max = -1;
        for(int i = 1 ; i <= N ; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);  
    }
}