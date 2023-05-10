import java.util.*;
import java.io.*;

public class Main {
    static int[][] D;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		D = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    D[i][1] = i;
		    D[i][0] = 1;
		    D[i][i] = 1;
		}
		
		for(int i = 2 ; i <= N ; i++) {
		    for(int j = 1 ; j < i ; j++) {
		        D[i][j] = D[i-1][j] + D[i-1][j-1];
                D[i][j] %= 10007;
		    }
		}
		
		System.out.println(D[N][K] % 10007);
        br.close();
	}
}