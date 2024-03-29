import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long mod = 1_000_000_000;
        
        long[] D = new long[1000001];
        D[1] = 0;
        D[2] = 1;
        
        for(int i = 3 ; i <= N ; i++) {
            D[i] = (i - 1) * (D[i - 2] + D[i - 1]) % mod;
        }
        System.out.println(D[N]);
    }
}
