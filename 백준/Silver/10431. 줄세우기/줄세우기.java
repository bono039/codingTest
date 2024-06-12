import java.util.*;
import java.io.*;

public class Main {
    static int T, P;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
        StringBuilder sb = new StringBuilder();
	    
	    P = Integer.parseInt(br.readLine());
	    while(P --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int[] arr = new int[20];
	        
	        for(int x = 0 ; x < 21 ; x++) {
	            if(x == 0)
                    T = Integer.parseInt(st.nextToken());
	            else
                    arr[x-1] = Integer.parseInt(st.nextToken());
	        }
	        
	        int cnt = 0;
	        for(int i = 0 ; i < 20 ; i++) {
	            for(int j = 0 ; j < i ; j++) {
	                if(arr[j] > arr[i]) cnt++;
	            }
	        }
	        sb.append(T + " " + cnt).append("\n");
	    }
	    System.out.println(sb.toString());
	}
}
