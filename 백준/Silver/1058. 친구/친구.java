import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 9999;
    
    static int N;
    static int[][] dist;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    
	    dist = new int[N][N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        String str = br.readLine();
	        for(int j = 0 ; j < N ; j++) {
	            
	            if(i == j) {
	                dist[i][j] = INF;
	                continue;
	            }
	            
	            char ch = str.charAt(j);
	            
	            if(ch == 'Y')
	                dist[i][j] = 1;
	            else
	                dist[i][j] = INF;
	        }
	    }
	    
	    for(int k = 0 ; k < N ; k++) {
    	    for(int i = 0 ; i < N ; i++) {
    	        for(int j = 0 ; j < N ; j++) {
    	            if(i == j || j == k || i == k)  continue;
    	            
    	            if(dist[i][j] > dist[i][k] + dist[k][j]) {
    	                dist[i][j] = dist[i][k] + dist[k][j];
    	            }
    	        }
    	    }	        
	    }
	    
	    int max = 0;
	    for(int i = 0 ; i < N ; i++) {
	        int cnt = 0;
	        
	        for(int j = 0 ; j < N ; j++) {
	            if(i == j)  continue;
	            
	            if(dist[i][j] <= 2) {
	                cnt++;
	            }
	        }
	        
	        max = Math.max(max, cnt);
	    }
	    
	    System.out.println(max);
	}
}
