import java.util.*;
import java.io.*;

public class Main {
    static double[][] dp = new double[101][101];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());   // a 개수
        int M = Integer.parseInt(st.nextToken());   // z 개수
        double K = Integer.parseInt(st.nextToken());   // K번쨰 문자열 구하기
        
        if(check(N, M) < K) {
            System.out.println(-1);
        }
        else {
            getResult(N, M, K);
            System.out.println(sb.toString());
        }
        
    }
    
    // 개수 구하는 함수 (dp배열 채움)
    private static double check(int a, int z) {
        if(a == 0 || z == 0)    return 1;
        if(dp[a][z] != 0)       return dp[a][z];
        
        return dp[a][z] = Double.min(check(a-1, z) + check(a, z-1), 1000000001);
    }
    
    // 문자열 만드는 함수
    private static void getResult(int a, int z, double k) {
        if(a == 0) {
            for(int i = 0 ; i < z ; i++) {
                sb.append("z");
            }
            return;
        }
        
        if(z == 0) {
            for(int i = 0 ; i < a ; i++) {
                sb.append("a");
            }
            return;
        }
        
        double check = check(a-1, z);
        if(k > check) {
            sb.append("z");
            getResult(a, z-1, k-check);
        }
        else {
            sb.append("a");
            getResult(a-1, z, k);
        }
    }
}
