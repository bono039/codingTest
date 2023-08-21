import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        
        int size = 1;
        int cnt = 0;
        
        while(size < K) size *= 2;
        System.out.print(size + " ");
        
        while(K > 0) {
            if(K >= size) {
                K -= size;
            }
            else {
                size /= 2;
                cnt++;
            }
        }
        
        System.out.print(cnt + "\n");
    }
}