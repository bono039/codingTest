import java.util.*;
import java.io.*;

public class Main {
    static int[] A, LIS;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        LIS = new int[N];
        LIS[0] = A[0];
        int end = 0;
        
        for(int i = 1 ; i < N ; i++) {
            if(LIS[end] > A[i]) {
                LIS[++end] = A[i];
            }
            else {
                int targetIdx = binarySearch(end, i);
                LIS[targetIdx] = A[i];
            }
        }
        
        System.out.println(end + 1);
    }
    
    private static int binarySearch(int end, int idx) {
        int start = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(LIS[mid] == A[idx])       return mid;
            else if(LIS[mid] > A[idx])   start = mid + 1;
            else if(LIS[mid] < A[idx])   end = mid - 1;
        }
        
        return start;
    }
}