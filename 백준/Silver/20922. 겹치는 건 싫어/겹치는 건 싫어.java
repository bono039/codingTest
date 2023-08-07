import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        int left = 0;
        int right = 0;
        int[] counting = new int[100001];
        
        while(left <= right) {
            if(right <= N - 1 && counting[A[right]] < K) {
                counting[A[right]]++;
                right++;
            }
            else if(counting[A[right]] == K) {
                counting[A[left]]--;
                left++;
            }
            
            result = Math.max(result, right - left);
            
            if(right == N)  break;
        }
        
        System.out.println(result);
    }
}