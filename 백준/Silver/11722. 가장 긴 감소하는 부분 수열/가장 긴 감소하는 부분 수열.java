import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        int result = 0;
        for(int i = N - 1 ; i >= 0 ; i--) {
            for(int j = N - 1 ; j > i ; j--) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(result);
    }
}
