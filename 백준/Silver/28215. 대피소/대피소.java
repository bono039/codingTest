import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    arr = new int[N][2];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        arr[i][0] = Integer.parseInt(st.nextToken());
	        arr[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    if(K == 1) {
	        for(int i = 0 ; i < N ; i++)
	            answer = Math.min(answer, calc(i, i, i));
	    }
	    else if(K == 2) {
    	    for(int i = 0 ; i < N - 1 ; i++) {
    	        for(int j = i + 1 ; j < N ; j++)
    	            answer = Math.min(answer, calc(i, j, j));
    	    }
	    }
	    
	    else if(K == 3) {
    	    for(int i = 0 ; i < N - 2 ; i++) {
    	        for(int j = i + 1 ; j < N - 1 ; j++) {
    	            for(int k = j + 1 ; k < N ; k++)
    	                answer = Math.min(answer, calc(i, j, k));
    	        }
    	    }     
	    }
	        
        System.out.println(answer);
	}
	
	private static int calc(int a, int b, int c) {
	    int ans = 0;
	    
	    for(int i = 0 ; i < N ; i++) {
	        int tmp1 = Math.abs(arr[i][0] - arr[a][0]) + Math.abs(arr[i][1] - arr[a][1]);
	        int tmp2 = Math.abs(arr[i][0] - arr[b][0]) + Math.abs(arr[i][1] - arr[b][1]);
	        int tmp3 = Math.abs(arr[i][0] - arr[c][0]) + Math.abs(arr[i][1] - arr[c][1]);
	        
	        ans = Math.max(ans, Math.min(Math.min(tmp1, tmp2), tmp3));
	    }
	    
	    return ans;
	}
}
