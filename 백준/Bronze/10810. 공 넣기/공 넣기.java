import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		for(int i = 0 ; i < m ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int from = Integer.parseInt(st.nextToken());
		    int to = Integer.parseInt(st.nextToken());
		    int ball = Integer.parseInt(st.nextToken());
		    
		    for(int j = from - 1 ; j < to ; j++) {
		        arr[j] = ball;		        
		    }
		}
		
		for(int i : arr) {
		    System.out.print(i + " ");
		}
	}
}