import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        
        for(int i = N - 1 ; i >= 2 ; i--) {
            if(A[i] < A[i - 2] + A[i - 1]) {
                System.out.println(A[i - 2] + A[i - 1] + A[i]);
                return;
            }
        }
        
        System.out.println(-1);
    }
}