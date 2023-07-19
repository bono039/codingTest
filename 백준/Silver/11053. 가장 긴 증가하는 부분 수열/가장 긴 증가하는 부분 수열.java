import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int LIS = 0;    // 처음 저장된 원소는 없으므로 값은 0
        
        for(int i = 0 ; i < N ; i++) {
            int idx = binarySearch(A[i], 0, LIS, LIS + 1);
            
            // 찾지 못한 경우, 가장 마지막 위치에 원소 삽입하고 LIS 길이 늘림
            if(idx == -1) {
                dp[LIS++] = A[i];
            }
            // 찾은 경우, 해당 위치에 현재 값 삽입해 갱신
            else {
                dp[idx] = A[i];
            }
        }

        int ans = 0;
        for(int i : dp) {
            if(i != 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
    
    // binary Search 활용한 LIS
    private static int binarySearch(int num, int s, int e, int size) {
        int pos = 0;    // 원소 위치 기억용 변수
        
        while(s <= e) {
            int mid = (s + e) / 2;
            
            if(num <= dp[mid]) {
                pos = mid;  
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        
        // dp 테이블에 삽입될 위치를 못 찾은 경우
        if(s == size)  {
            return -1;
        }
        // dp 테이블에 삽입될 위치를 찾은 경우
        else {
            return pos;
        }
    }
}
