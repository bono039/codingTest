import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        System.out.println((n * m) / gcd(n, m));
    }
  
    // 최대공약수 구하는 메소드 (유클리드 호제법)
    private static int gcd(int a, int b) {        
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
