import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new int[N];
	    
	    String[] str = br.readLine().split(" ");
	    for(int i = 0 ; i < str.length ; i++) {
	        arr[i] = Integer.parseInt(str[i]);
	    }
	    
	    Arrays.sort(arr);
	    
	    int sum = arr[0];
	    
	    for(int i = 1 ; i < N ; i++) {
	        arr[i] += arr[i-1];
	        sum += arr[i];
	    }
	    
	    System.out.println(sum);
	}
}
