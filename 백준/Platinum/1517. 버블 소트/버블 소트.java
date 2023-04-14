import java.util.*;
import java.io.*;

public class Main {
    static long[] A;
    static long[] tmp;
    static long result;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    A = new long[N + 1];
	    tmp = new long[N + 1];
	    
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		merge_sort(1, N);   // 병합 정렬
		
		System.out.println(result);
	}
	
	public static void merge_sort(int s, int e) {
	    if(e - s < 1)
	        return;
	   
	    int mid = s + (e - s) / 2;
	    merge_sort(s, mid);
	    merge_sort(mid + 1 , e);
	    
	    // tmp 배열 저장
	    for(int i = s ; i <= e ; i++) {
	        tmp[i] = A[i];
	    }
	    
	    // 두 그룹 병합
	    int tmpIdx = s; // 현재 복사 위치
	    int idx1 = s;
	    int idx2 = mid + 1;
	    
	    while(idx1 <= mid && idx2 <= e) {
	        if(tmp[idx1] > tmp[idx2]) {
	            // 뒤쪽 데이터 값이 작은 경우 업데이트
	            A[tmpIdx] = tmp[idx2];
	            result += idx2 - tmpIdx;
	            tmpIdx++;
	            idx2++;
	        }
	        else {
	            A[tmpIdx++] = tmp[idx1++];
	        }
	    }
	    
	    
	    // 부분이 남은 경우
	    while(idx1 <= mid) {
	        A[tmpIdx++] = tmp[idx1++];
	    }
	    while(idx2 <= e) {
	        A[tmpIdx++] = tmp[idx2++];
	    }
	}
}