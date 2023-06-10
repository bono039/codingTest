import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        long n = Long.parseLong(br.readLine());
        
        while(n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            long d = a * b / gcd(a,b);
            sb.append(d).append("\n");
        }
        System.out.print(sb);
    }
    
    private static long gcd(long x, long y) {
        if(y == 0)  return x;
        return gcd(y, x % y);
    }
}