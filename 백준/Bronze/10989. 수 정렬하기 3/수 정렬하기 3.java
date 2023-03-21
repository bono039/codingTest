import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];          // 수열 원소 : n개
	    int[] counting = new int[10001]; // 수의 범위 : 1 ~ 10000
	    int[] result = new int[n];       // 정렬될 배열
	    
	    // Counting sort
	    // 과정 1
	    for(int i = 0 ; i < arr.length ; i++) {
	        arr[i] = Integer.parseInt(br.readLine());
	        counting[arr[i]]++;
	    }
	    
	    br.close();
	    
	    
	    // 과정 2
	    var sb = new StringBuilder();
	    for(int i = 1 ; i < counting.length ; i++) {
	        while(counting[i] > 0) {
	            sb.append(i).append('\n');
	            counting[i]--;
	        }
	    }
	 
		System.out.println(sb);
	}
}