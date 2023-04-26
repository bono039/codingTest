import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long result = n;
		
		for(long p = 2 ; p <= Math.sqrt(n) ; p++) { // 제곱근까지만 진행
		    if(n % p == 0) {                        // p가 소인수인지 확인
		        result = result - result / p;       // 결괏값 업데이트
		        
		        while(n % p == 0) {
		            n /= p;
		        }
		    }
		}
		
		// 아직 소인수 구성이 남아 있을 때
		if(n > 1) {
		    result = result - result / n;
		}
		System.out.println(result);
	}
}