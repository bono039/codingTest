import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		long Min = Long.parseLong(st.nextToken());
		long Max = Long.parseLong(st.nextToken());
		long[] A = new long[10000001];

        for(int i = 2 ; i < A.length ; i++) {
            A[i] = i;
        }

		
		for(int i = 2 ; i <= Math.sqrt(A.length) ; i++) {
		    if(A[i] == 0) {
		        continue;
		    }

		    for(int j = i + i ; j < A.length ; j += i) {
		        A[j] = 0;
		    }
		}
		
		
		int cnt = 0;
		for(int i = 2 ; i < A.length ; i++) {
		    if(A[i] != 0) {
		        long tmp = A[i];    // 현재 소수
		        
		        while((double)A[i] <= (double)Max / (double)tmp) {
		            if((double)A[i] >= (double)Min / (double)tmp) {
		                cnt++;
		            }
		            
		            tmp *= A[i];
		        }
		    }
		}

		System.out.println(cnt);
	}
}