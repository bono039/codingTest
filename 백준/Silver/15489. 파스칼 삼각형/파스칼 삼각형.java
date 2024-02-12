import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    int R = Integer.parseInt(st.nextToken());
	    int C = Integer.parseInt(st.nextToken());
	    int W = Integer.parseInt(st.nextToken());
	    
	    int[][] triangle = new int[R + W][R + W];
	    for(int i = 1 ; i < triangle.length ; i++) {
	        triangle[i][1] = 1;
	        triangle[i][i] = 1;
	    }
	    
	    for(int i = 1 ; i < triangle.length ; i++) {
	        for(int j = 1 ; j < i ; j++) {
	            if(i==j)    continue;
	            triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
	        }
	    }
	    	    
	    int sum = 0;
	    int tmp = 0;
	    for(int i = R ; i < R + W ; i++) {
	        tmp = i - R;
	        
	        for(int j = C ; j < C + W ; j++) {
	            if(R <= i && i < R + W && C <= j && j <= C + tmp) {
	                sum += triangle[i][j];
	            }
	        }
	    }
	    
	    System.out.println(sum);
	}
}
