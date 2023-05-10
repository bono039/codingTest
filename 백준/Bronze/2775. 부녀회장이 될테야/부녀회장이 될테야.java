import java.util.*;
import java.io.*;

public class Main {
    static int T, K, N;
    static int[][] D;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		D = new int[15][15];
		for(int i = 0 ; i < 15 ; i++) {
		    D[i][1] = 1;
		    D[0][i] = i;
		}
		
		for(int i = 1 ; i < 15 ; i++) {
		    for(int j = 2 ; j < 15 ; j++) {
		        D[i][j] = D[i][j - 1] + D[i - 1][j];
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < T ; i++) {
		     int K = Integer.parseInt(br.readLine());
		     int N = Integer.parseInt(br.readLine());
		     
		     sb.append(D[K][N] + "\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}