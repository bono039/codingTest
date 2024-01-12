import java.util.*;
import java.io.*;

public class Main {    
    static int T, n, d;
    static int[][] grid, copy;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    
	    while(T --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        n = Integer.parseInt(st.nextToken());
	        d = Integer.parseInt(st.nextToken());
	        
	        grid = new int[n][n];
	        copy = new int[n][n];
	        for(int i = 0 ; i < n ; i++) {
	            st = new StringTokenizer(br.readLine(), " ");
	            for(int j = 0 ; j < n ; j++) {
	                grid[i][j] = Integer.parseInt(st.nextToken());
	                copy[i][j] = grid[i][j];
	            }
	        }
	        
	        if(d < 0) d += 360;
	        if(d >= 360) d -= 360;
	        
	        int cnt = d/45;
	        while(cnt --> 0) {
	            rotate();
	        }
	        
            for(int[] i : grid) {
                for(int j : i) {
                    sb.append(j + " ");
                }
                sb.append("\n");
            }
	    }
	    
	    System.out.println(sb);
	}
	
	private static void rotate() {
	    for(int i = 0 ; i < n ; i++) {
	        copy[i][n / 2] = grid[i][i];
	        copy[n - 1 - i][i] = grid[n - 1 - i][n / 2];
	        copy[n / 2][i] = grid[n - 1 - i][i];
	        copy[i][i] = grid[n / 2][i];
	    }
	    
	    for(int i = 0 ; i < n ; i++) {
	        for(int j = 0 ; j < n ; j++) {
	            grid[i][j] = copy[i][j];
	        }
	    }
	}
}
