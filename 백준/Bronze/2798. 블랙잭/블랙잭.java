import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int goal = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0 ; i < n ; i++) {
		    
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < n-2 ; i++) {
		    for(int j = i + 1 ; j < n - 1 ; j++) {
		        for(int k = j + 1 ; k < n ; k++) {
		           list.add(arr[i] + arr[j] + arr[k]);
		        }
		    }
		}
		
		int diff = 300000;
		int answer = 0;
		for(int val : list) {
		    if((val <= goal) && (goal - val) < diff) {
		        diff = goal - val;
		        answer = val;
		    }
		}
		
		System.out.println(answer);
	}
}