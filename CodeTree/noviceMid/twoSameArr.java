import java.util.*;
import java.io.*;
 
public class Main {
    static int N;
    static int[] A, B;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
 
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
 
        System.out.println(isSame(A, B) ? "Yes" : "No");        
    }
 
    // 두 배열 같은지 판별 함수
    private static boolean isSame(int[] a, int[] b) {
        for(int i = 0 ; i < N ; i++) {
            if(A[i] != B[i])
                return false;
        }
        return true;
    }
}
