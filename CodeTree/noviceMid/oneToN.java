import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.println(recur(N));        
    }
 
    private static int recur(int n) {
        if(n == 0) return 0;
        return recur(n-1) + n;
    }
}
