import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt;
    static int[] levels;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        levels = new int[N + 1];
        
        for(int i = 1 ; i <= N ; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = N - 1 ; i >= 1 ; i--) {
            while(levels[i] >= levels[i + 1]) {
                levels[i]--;
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}