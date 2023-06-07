import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        int cnt = 0;
        for(int k = 0 ; k < N ; k++) {
            long find = A[k];
            
            int s = 0;
            int e = N - 1;            
            
            while(s < e) {
                long sum = A[s] + A[e];
                
                if(sum == find) {
                    if(s != k && e != k) {
                        cnt++;
                        break;
                    }
                    else if(s == k) {
                        s++;
                    }
                    else if(e == k) {
                        e--;
                    }
                }
                else if(sum < find) {
                    s++;
                }
                else if(sum > find) {
                    e--;
                }
            }   
            
        }
        System.out.println(cnt);
    }
}