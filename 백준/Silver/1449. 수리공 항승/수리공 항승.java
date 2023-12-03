import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[1001];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
	    Arrays.sort(arr);
	    
	    int cnt = 0;
	    for(int i = 0 ; i < N ; i++) {
	        if(visited[arr[i]])  continue;
	        
	        cnt++;
	        for(int j = arr[i] ; (j < arr[i] + L) && j <= 1000 ; j++) {
	            if(!visited[j]) {
    	            visited[j] = true;
	            }
	        }
	    }
	    
	    System.out.println(cnt);
	}
}
