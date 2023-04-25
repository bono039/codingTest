import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[10000001];
		
		// 소수 판정 먼저
		// 1. 배열 초기화
		for(int i = 2 ; i < A.length ; i++) {
		    A[i] = i;
		}
		
		for(int i = 2 ; i < Math.sqrt(A.length) ; i++) {
		    if(A[i] == 0) {
		        continue;
		    }
		       
		    // 배수 지우기
		    for(int j = i+i ; j < A.length ; j += i) {
		        A[j] = 0;
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = N ; ; i++) {
		    if(A[i] != 0 && isPalindrome(A[i])) {
		        sb.append(A[i]);
		        break;
		    }
		}
		
		System.out.println(sb);
	}
	
	
	static boolean isPalindrome(int num) {
	    String str = Integer.toString(num);
	    int len = str.length();
	    
	    for(int i = 0 ; i < len / 2 ; i++) {
            if(str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
	    }	    
	    
	    return true;
	} 
}