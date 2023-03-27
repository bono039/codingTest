import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i < n ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		    
		    boolean flag = true;
		    
		    if(arr[i] == 1) flag = false;
		    
		    for(int j = 2 ; j <= Math.sqrt(arr[i]) ; j++) {
		        if(arr[i] % j == 0) {
		            flag = false;
		            break;
		        }
		    }
		    
		    if(flag) cnt++;
		}
		
		System.out.println(cnt);
	}
}