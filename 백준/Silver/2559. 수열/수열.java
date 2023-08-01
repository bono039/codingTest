import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sum = new int[N];
        sum[0] = A[0];
        for(int i = 1 ; i < N ; i++) {
            sum[i] = sum[i-1] + A[i];
        }
        
        int max = sum[range - 1];
        for(int i = range - 1 ; i < N ; i++) {
            if(i >= range) {
                max = Math.max(max, sum[i] - sum[i-range]);
            }
        }
        
        System.out.println(max);
        
    }
}