import java.util.*;
import java.io.*;

public class Main {
    static long[] A, tmp;
    static long cnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		int N = Integer.parseInt(br.readLine());
		A  = new long[N + 1];
		tmp  = new long[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = Long.parseLong(st.nextToken());
		}
		
		cnt = 0;
		merge_sort(1, N);
		System.out.println(cnt);
	}
	
	private static void merge_sort(int s, int e) {
	    if(s < e) {
	        int mid = s + (e - s) / 2;
	        merge_sort(s, mid);
	        merge_sort(mid + 1, e);
	        merge(s, mid, e);
	    }
	}
	
	private static void merge(int s, int m, int e) {
	    for(int i = s ; i <= e ; i++) {
	        tmp[i] = A[i];
	    }
	    
	    int l = s;
	    int r = m + 1;
	    int idx = s;
	    
	    while(l <= m && r <= e) {
	        if(tmp[l] <= tmp[r]) {
	            A[idx] = tmp[l];
	            l++;
	        } else {
	            A[idx] = tmp[r];
	            cnt += (m + 1 - l);
	            r++;
	        }
	        idx++;
	    }
	    
	    while(l <= m) {
	        A[idx++] = tmp[l++];
	    }
	}
}