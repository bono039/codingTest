import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine(), " ");
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int[][] arr = new int[n+1][n+1];
	    int[][] sum = new int[n+1][n+1];
	    
	    // 표 채우기
	    for(int i = 1 ; i <= n ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 1 ; j <= n ; j++) {
	            arr[i][j] = Integer.parseInt(st.nextToken());
	            sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
	        }
	    }
	    
        // 네 개의 정수 받기
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int result = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            System.out.println(result);
            
        }   
	}
}