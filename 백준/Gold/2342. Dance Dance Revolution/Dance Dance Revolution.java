import java.util.*;
import java.io.*;

public class Main {
    static int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        while(true) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 0)    break;
            list.add(num);        
        }
        
        int len = list.size();
        int[][][] dp = new int[len][5][5];
        for(int k = 0 ; k < len ; k++) {
            for(int i = 0 ; i < 5 ; i++) {
                for(int j = 0 ; j < 5 ; j++) {
                    dp[k][i][j] = INF;
                }
            }
        }
        dp[0][0][0] = 0;
        
        for(int idx = 0 ; idx < len - 1 ; idx++) {
            int next = list.get(idx + 1);
            
            for(int i = 0 ; i < 5 ; i++) {
                for(int j = 0 ; j < 5 ; j++) {
                    int now = dp[idx][i][j];
                    
                    if(next != j) {
                        dp[idx + 1][next][j] = Math.min(dp[idx + 1][next][j], now + solve(i, next));
                    }
                    if(next != i) {
                        dp[idx + 1][i][next] = Math.min(dp[idx + 1][i][next], now + solve(j, next));
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < 5 ; i++) {
            for(int j = 0 ; j < 5 ; j++) {
                ans = Math.min(ans, dp[len - 1][i][j]);
            }
        }
        
        System.out.println(ans);
    }
    
    private static int solve(int l, int r) {
        if(l == r)      return 1;
        else if(l == 0) return 2;
        else if(Math.abs(l - r) == 2) return 4;
        else return 3;
    }
}
