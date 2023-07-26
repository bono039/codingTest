import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[1000001];
		
		while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
		    int x = Integer.parseInt(st.nextToken());
		    int g = Integer.parseInt(st.nextToken());
		    
		    A[g] = x;
		}
		
		int sum = 0;
		int max = 0;
		int d = 1 + (2 * K);
		
		for(int i = 0 ; i <= 1000000 ; i++) {
		    if(i >= d) {
		        sum -= A[i - d];
		    }
		    
		    sum += A[i];
		    if(sum > max) {
		        max = sum;
		    }
		}
		
		System.out.println(max);
	}
}
