import java.util.*;
import java.io.*;

public class Main {
    public static int N, S;
    public static int[] arr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		
		int sum = 0;
		int answer = Integer.MAX_VALUE;
		
		while(left <= right) {
		    if(sum >= S) {
		        answer = Math.min(answer, right - left);
		        sum -= arr[left++];
		    }
		    else if(right == N) {
		        break;
		    }
		    else {
		        sum += arr[right++];
		    }
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}