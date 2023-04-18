import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A); // 이진 탐색 위해 정렬
		
		// 존재하는지 비교할 숫자
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < M ; i++) {
		    boolean find = false;
		    int target = Integer.parseInt(st.nextToken());
		    
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
            
            if(find) sb.append(1).append("\n");
            else     sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}