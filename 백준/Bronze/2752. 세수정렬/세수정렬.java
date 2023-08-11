import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
        long[] A = new long[3];
		for(int i = 0 ; i < 3 ; i++) {
		    A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		
		for(long a : A) {
		    System.out.print(a + " ");
		}
		System.out.println();
	}
}
