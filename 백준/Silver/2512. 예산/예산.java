import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(A);
        
        int left = 0;
        int right = A[N - 1];
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long budget = 0;
            
            for(int i = 0 ; i < N ; i++) {
                if(A[i] > mid) budget += mid;
                else           budget += A[i];
            }
            
            if(budget <= M) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        System.out.println(right);
    }
}