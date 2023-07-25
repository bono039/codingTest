import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N + 1];
        int[] sum = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + A[i];
        }
        
        int maxVisit = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = X ; i <= N ; i++) {
            int tmp = sum[i] - sum[i - X];
            
            if(tmp > max) {
                cnt = 1;
                max = tmp;
            }
            else if(tmp == max) {
                cnt++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
        
    }
}