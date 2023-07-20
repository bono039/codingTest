import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(A);
        
        long gap = Integer.MAX_VALUE;
        
        int s = 0;
        int e = N - 1;
        
        long ans1 = 0;
        long ans2 = 0;
        
        while(s < e) {
            long sum = A[s] + A[e];
            long tmp = Math.abs(sum);
            
            if(tmp < gap) {
                gap = tmp;
                ans1 = A[s];
                ans2 = A[e];
            }   
                
            if(sum < 0) {
                s++;
            }
            else {
                e--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
