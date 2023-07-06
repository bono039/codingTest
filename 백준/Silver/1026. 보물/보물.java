import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        long sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0 ; i < N ; i++) {
            sum += A[N - i - 1] * B[i];
        }
        System.out.println(sum);
    }
}
