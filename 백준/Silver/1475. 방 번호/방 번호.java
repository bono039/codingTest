import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int[] A = new int[10];
        
        for(int i = 0 ; i < str.length() ; i++) {
            int tmp = str.charAt(i) - '0';
            
            if(tmp == 6) A[9]++;
            else         A[tmp]++;
        }
        
        int max = 0;
        for(int i = 0 ; i < 9 ; i++) {
            max = Math.max(max, A[i]);
        }
        
        int nine = A[9] / 2;
        if(A[9] % 2 == 1)   nine++;
        max = Math.max(max, nine);
        
        System.out.println(max);
    }
}