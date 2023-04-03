import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine(), " ");
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int[] arr = new int[n];     // N개의 수
	    int[] sumArr = new int[n];  // 구간 합 배열
	    
	    // N개의 수
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < n ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 구간 합 구하기
	    sumArr[0] = arr[0];
	    for(int i = 1 ; i < n ; i++) {
	        sumArr[i] = sumArr[i-1] + arr[i];
	    }
	    
	    // 구간 i,j
	    for(int i = 0 ; i < m ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        int a = Integer.parseInt(st.nextToken()) -1;
	        int b = Integer.parseInt(st.nextToken()) -1;
	        
	        if(a == 0) {
	            System.out.println(sumArr[b]);
	        } else {
	            System.out.println(sumArr[b] - sumArr[a - 1]);
	        }
	    }
	}
}