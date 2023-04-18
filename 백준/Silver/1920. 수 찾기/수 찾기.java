import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
		    A[i] = sc.nextInt();
		}
		
		Arrays.sort(A); // 이진 탐색 위해 정렬
		
		// 존재하는지 비교할 숫자
		int M = sc.nextInt();
		int[] B = new int[M];
		
		for(int i = 0 ; i < M ; i++) {
		    boolean find = false;
		    int target = sc.nextInt();
		    
		    int start = 0;
		    int end = A.length - 1;
		    
		    while(start <= end) {
		        int mid = (start + end) / 2; // 중앙값
		        
		        if(A[mid] > target) {
		            end = mid - 1;
		        }
		        else if(A[mid] < target) {
		            start = mid + 1;
		        }
		        else {
		            find = true;
		            break;
		        }
		        
		    }
            
            if(find) System.out.println(1);
            else     System.out.println(0);
		}
	}
}