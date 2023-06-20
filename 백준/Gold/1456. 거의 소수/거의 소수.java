import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long[] arr = new long[10000001];
		
		for(int i = 2 ; i < arr.length ; i++) {
		    arr[i] = i;
		}
		
		// 소수 체크하기
		for(int i = 2 ; i <= Math.sqrt(arr.length) ; i++) {
		    if(arr[i] == 0) continue;
		    
		    for(int j = i + i ; j < arr.length ; j += i) {
		        arr[j] = 0;
		    }
		}
		
		int cnt = 0;
		for(int i = 2 ; i < arr.length ; i++) {
		    if(arr[i] != 0) {
		        long tmp = arr[i];    // 현재 소수
		        
		        while((double)arr[i] <= (double) B / (double)tmp) {
		            if((double)arr[i] >= (double)A / (double)tmp) {
		                cnt++;
		            }
		            
		            tmp *= arr[i];
		        }
		    }
		}
		
		System.out.println(cnt);
	}
}
