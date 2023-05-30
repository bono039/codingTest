import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] A = new int[100001];
        
        for (int i = 0; i < n; i++) {
            A[i + 1] = Integer.parseInt(str[i]);
        }
        
        long[] S = new long[100001];
        S[1] = A[1];
        for (int i = 2; i <= n; i++) {
            if (S[i - 1] + A[i] < A[i]) {
                S[i] = A[i];
            } else {
                S[i] = A[i] + S[i - 1];
            }
        }
        
        long answer = -1000;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, S[i]);
        }
        System.out.println(answer);
    }
}