import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());    // 배열 크기
		int k = Integer.parseInt(br.readLine());

		long start = 1;
		long end = k;
		long answer = 0;
		
		// 이진 탐색
		while(start <= end) {
		    long mid = (start + end) / 2;
		    long cnt = 0;    // k보다 작은 수
		    
		    for(int i = 1 ; i <= N ;  i++) {
		        cnt += Math.min(mid / i, N);    // 작은 수 카운트
		    }
		    
		    if(cnt < k) {
		        start = mid + 1;
		    }
		    else {
		        answer = mid;   // 현재 단계 중앙값을 정답 변수에 저장
		        end = mid - 1;
		    }
		}
		
		System.out.println(answer);
	}
}