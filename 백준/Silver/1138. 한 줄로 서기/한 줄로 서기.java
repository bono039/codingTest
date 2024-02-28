import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer> ans = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new int[N + 1]; 
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= N ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i = N ; i >= 1 ; i--) {
	        ans.add(arr[i], i);
	    }
	    
	    for(int k : ans) {
	        System.out.print(k + " ");
	    }
	}
}
