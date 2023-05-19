import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0 ; i < T ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int arr[] = new int[10];
		    
		    for(int j = 0 ; j < 10 ; j++) {
		        arr[j] = Integer.parseInt(st.nextToken());
		    }
		    
		    Arrays.sort(arr);
		    System.out.println(arr[7]);
		}
	}
}