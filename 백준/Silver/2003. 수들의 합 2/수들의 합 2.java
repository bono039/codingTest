import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int l = 0;
        int r = 0;
        int cnt = 0;
        
        while(r <= N) {
            if(sum >= M) {
                sum -= A[l++];
            }
            else if(sum < M) {
                sum += A[r++];
            }
            
            if(sum == M) cnt++;
        }
        
        System.out.println(cnt);
    }
}
