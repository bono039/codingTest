import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine(), " ");
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    long[] S = new long[n];   // 합 배열
	    long[] C = new long[m];   // 나머지 배열
	    
	    long answer = 0;
	    st = new StringTokenizer(br.readLine(), " ");
	    S[0] = Integer.parseInt(st.nextToken());
	    
	    // 수열 합 배열 만들기
	    
	    for(int i = 1 ; i < n ; i++) {
	        S[i] = S[i-1] + Integer.parseInt(st.nextToken());
	    }
	    
	    // 합 배열의 모든 값에 % 연산 수행하기
	    for(int i = 0 ; i < n ; i++) {
	        int remainder = (int) (S[i] % m);
	        
	        if(remainder == 0) answer++;
	        
	        C[remainder]++; // 나머지가 같은 갯수 카운트
	    }
	    
	    // 나머지가 같은 인덱스 중 2개 뽑는 경우의 수 계산
	    for(int i = 0 ; i < m ; i++) {
	        if(C[i] > 1) {
	            answer = answer + (C[i] * (C[i] - 1) / 2);
	        }
	    }
	    
	    System.out.println(answer);
	}
}