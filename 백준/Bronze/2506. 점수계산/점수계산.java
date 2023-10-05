import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] result = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		result[0] = A[0];
		
		boolean isContinuous = false;
		for(int i = 1 ; i < N ; i++) {
		    if(A[i] == 1) {
		        if(A[i-1] == 0) {
		            result[i] = 1;
		        }
		        else {
		            result[i] = result[i-1] + 1;
		        }
		    }
		}
		
		int total = 0;
		for(int i: result)    total += i;
			
		System.out.println(total);
	}
}
