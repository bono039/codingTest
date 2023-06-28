import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] A = new long[K];
		long max = 0;
		long min = 0;
		long mid = 0;

		for(int i = 0 ; i < K ; i++) {
		    A[i] = Long.parseLong(br.readLine());
		    if(A[i] > max) max = A[i];
		}

        max++;
		while(min < max) {
		    mid = (min + max) / 2;
		    
		    long total = 0;
		    for(int i = 0 ; i < K ; i++) {
		        total += A[i] / mid;
		    }
		    
		    if(total < N) {
		        max = mid;
		    } else {
		        min = mid + 1;
		    }
		}

		System.out.println(min - 1);
	}
}
