import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A[][] = new int[10001][2];
		int DP[] = new int[10001];
		
		for(int i = 1 ; i <= 10 ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    A[i][0] = Integer.parseInt(st.nextToken());
		    A[i][1] = Integer.parseInt(st.nextToken());
		    
		    DP[0] = A[0][0] = A[0][1] = 0;
		    DP[i] = DP[i-1] - A[i-1][0] + A[i-1][1];
		}
		
		Arrays.sort(DP);
		System.out.println(DP[10000]);
	}
}