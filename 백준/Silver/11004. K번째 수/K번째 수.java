import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 퀵 정렬
		quickSort(A, 0, N - 1, K - 1);
		System.out.println(A[K - 1]);
	}
	
	// 퀵 정렬 메소드
	public static void quickSort(int[] A, int S, int E, int K) {
	    if(S < E) {
	        int pivot = partition(A, S, E);
	        
    	    if(pivot == K)     return;
    	    else if(K < pivot) quickSort(A, S, pivot - 1, K);
    	    else if(K > pivot) quickSort(A, pivot + 1, E, K); 
	    }
	}
	
	// 피벗 구하기 메소드
	public static int partition(int[] A, int S, int E) {
	    // 데이터가 2개인 경우, 바로 비교해 정렬
	    if(S + 1 == E) {
	        if(A[S] > A[E]) swap(A, S, E);
	        return E;
	    }
	    
	    int M = (S + E) / 2;    // 배열 중간 위치를 pivot으로 설정
	    swap(A, S, M);          // 중앙값을 첫 번째 요소로 이동
	    
	    
	    int pivot = A[S];
	    int i = S + 1;
	    int j = E;
	    
	    while(i <= j) {
	        // 피벗보다 큰 수가 나올 때까지 i++
	        while(i <= E && pivot > A[i]) {
	            i++;
	        }	        
	        // 피벗보다 작은 수가 나올 때까지 j--
	        while(j >= S + 1 && pivot < A[j]) {
	            j--;
	        }
	        
	        // 찾은 i와 j를 swap
	        if(i <= j) {
	            swap(A, i++, j--);
	        }
	    }
	    
	    // 피벗 데이터를 나눠진 두 그룹의 경계 idx에 저장
	    A[S] = A[j];
	    A[j] = pivot;
	    return j;   // 경계 idx 리턴
	}
	
	public static void swap(int[] A, int i, int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;
	}
}