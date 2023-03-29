import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for(int i=0 ; i < n ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    arr1[i] = Integer.parseInt(st.nextToken());
		    arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int minX = arr1[0];
		int maxX = arr1[n-1];
		int minY = arr2[0];
		int maxY = arr2[n-1];
		
		System.out.println(Math.abs(maxY - minY) * Math.abs(maxX - minX));
	}
}