import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Matrix[] M;
    static int[][] D;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = new Matrix[N + 1];
		D = new int[N + 1][N + 1];
		
		for(int i = 0 ; i < D.length ; i++) {
		    for(int j = 0 ; j < D[i].length ; j++) {
		        D[i][j] = -1;
		    }
		}
	
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int r = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    M[i] = new Matrix(r, c);
		}

		System.out.println(execute(1, N));
	}
	
	static int execute(int s, int e) {
	    int result = Integer.MAX_VALUE;
	    
	    if(D[s][e] != -1)
	        return D[s][e];
	    if(s == e)
	        return 0;
	    if(s + 1 == e)
	        return M[s].r * M[s].c * M[e].c;
	    for(int i = s ; i < e ; i++)
	        result = Math.min(result, execute(s, i) + execute(i + 1, e) + M[s].r * M[i].c * M[e].c);
	    return D[s][e] = result;
	}
	
	static class Matrix {
	    private int r;
	    private int c;
	    Matrix(int r, int c) {
	        this.r = r;
	        this.c = c;
	    }
	}
}