import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N + 1];
		
		// 각 인덱스 값으로 초기화
		for(int i = 2 ; i <= N ; i++) {
		    A[i] = i;
		}
		
		for(int i = 2 ; i <= Math.sqrt(N) ; i++) {
		    if(A[i] == 0)
		        continue;
		    
		    // 배수 지우기
		    for(int j = i + i ; j <= N ; j = j + i) {
		        A[j] = 0;
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = M ; i<= N ; i++) {
		    if(A[i] != 0) {
		        sb.append(A[i]).append("\n");
		    } 
		}
		System.out.println(sb);
	}
}