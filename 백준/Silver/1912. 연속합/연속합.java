import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n + 1];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1 ; i <= n ; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		
	    long[] S = new long[100_001];
		S[1] = A[1];
		
		for(int i = 2 ; i <= n ; i++) {
		    if(S[i-1] + A[i] < A[i]) {
		        S[i] = A[i];
		    } else {
		        S[i] = A[i] + S[i - 1];
		    }
		}
		
		long answer = -1000;
		for(int i = n ; i > 0 ; i--) {
		    answer = Math.max(answer, S[i]);
		}
		System.out.println(answer);
	}
}