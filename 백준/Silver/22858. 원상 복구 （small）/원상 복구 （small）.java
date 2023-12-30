import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] arr, D, tmp;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    arr = new int[N + 1];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= N ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    D = new int[N + 1];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= N ; i++) {
	        D[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    while(K --> 0) {
	        tmp = new int[N + 1];
	        
	        for(int i = 1 ; i <= N ; i++) {
	            tmp[D[i]] = arr[i];
	        }
	        arr = tmp;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 1 ; i <= N ; i++) {
	        sb.append(arr[i] + " ");
	    }
	    System.out.println(sb);
	}
}
