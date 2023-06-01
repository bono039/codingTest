import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        
        for(int i = 1; i <= N ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        int[] DP = new int[N + 1];
        DP[1] = A[1];
        
        if(N >= 2) {
            DP[2] = A[1] + A[2];
        }
        
        for(int i = 3 ; i <= N ; i++) {
            DP[i] = A[i] + Math.max(DP[i - 2], DP[i - 3] + A[i - 1]);
        }
        
        System.out.println(DP[N]);
    }
}