import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N + 1];
        long[] sum = new long[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        sum[1] = arr[1];
        for(int i = 2 ; i <= N ; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        
        long result = 0;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            result = (a == b) ? arr[a] : (sum[b] - sum[a - 1]);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}