import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N + 1];
		
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = N ; i >= 1 ; i--) {
		    if(A[i] > K)    continue;
		    else {
		        cnt += K / A[i];
		        K %= A[i];
		    }
		}
		System.out.println(cnt);
	}
}