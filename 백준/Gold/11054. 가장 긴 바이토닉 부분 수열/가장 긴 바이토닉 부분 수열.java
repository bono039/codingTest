import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] seq;
    static int[] r_dp;
    static int[] l_dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        seq = new int[N + 1];
        r_dp = new int[N + 1];
        l_dp = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            r_dp[i] = 1;
            l_dp[i] = 1;
        }
        
        LIS();
        LDS();
        
        int max = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }
        
        System.out.println(max - 1);
    }
    
    static void LIS() {
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j < i ; j++) {
                if(seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }
    }
    
    static void LDS() {
        for(int i = N ; i >= 1 ; i--) {
            for(int j = N ; j > i ; j--) {
                if(seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }
    }
}