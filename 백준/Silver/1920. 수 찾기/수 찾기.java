import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		while(m --> 0) {
		    boolean find = false;
		    int target = Integer.parseInt(st.nextToken());
		    
		    int s = 0;
		    int e = A.length - 1;
		    
		    while(s <= e) {
		        int mid = (s + e) / 2;
		        
		        if(A[mid] == target) {
		            find = true;
		            break;
		        }
		        else if(A[mid] < target) {
		            s = mid + 1;
		        }
		        else if(A[mid] > target) {
		            e = mid - 1;
		        }
		    }
		    
		    sb.append(find ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}