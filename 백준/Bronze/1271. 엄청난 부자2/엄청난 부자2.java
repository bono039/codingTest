import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        BigInteger n = new BigInteger(st.nextToken());   // 조교가 가진 돈
        BigInteger m = new BigInteger(st.nextToken());   // 생명체 수
        
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
        
    }
}
