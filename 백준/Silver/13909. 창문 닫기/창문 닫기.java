import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for(int j = 1 ; j <= Math.sqrt(N) ; j++) {
            cnt++;
        }
        
        System.out.println(cnt);  
    }
}