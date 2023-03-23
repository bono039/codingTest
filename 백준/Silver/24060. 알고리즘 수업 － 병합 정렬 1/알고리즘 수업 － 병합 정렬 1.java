import java.util.*;
import java.io.*;

public class Main {
    int[] A;
    static int[] tmp;
    static int k;
    static int cnt = 0;
    static int result = -1;
    
    public static void merge_sort(int A[], int p, int r) {  
        if(p < r) {
            int q = (p+r) / 2;
            merge_sort(A, p, q);    // 전반부 정렬
            merge_sort(A, q + 1, r);// 후반부 정렬
            merge(A, p, q, r);      // 병합
        }
    }
    
    private static void merge(int A[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        
        while(i <= q && j <= r) {
            if(A[i] < A[j])
                tmp[t++] = A[i++];
            else
                tmp[t++] = A[j++];
        }
        
        while(i <= q) { // 왼쪽 배열이 남은 경우
            tmp[t] = A[i];
            t++;
            i++;
        }
        while(j <= r) { // 오른쪽 배열이 남은 경우
            tmp[t++] = A[j++];
        }
        
        
        i = p;
        t = 0;
        while(i <= r) {   // 결과를 배열 A에 저장
            cnt++;
            
            if(cnt == k) {
                result = tmp[t];
                break;
            }
            
            A[i++] = tmp[t++];
        }
    }
    
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		
        int n = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        tmp = new int[n];        
        merge_sort(A, 0, n-1);
        System.out.println(result);
	}
}