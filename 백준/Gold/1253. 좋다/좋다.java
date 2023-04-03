import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		int cnt = 0;
		
        var st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
		    arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int k = 0 ; k < N ; k++) {
		    long find = arr[k]; // 찾고자 하는 값
		    int i = 0;
		    int j = N - 1;
		    
		    // 투 포인터 알고리즘
		    while(i < j) {
		        if(arr[i] + arr[j] == find) {
		            // 서로 다른 두 수의 합인지 확인
		            if(i != k && j != k)  {
		                cnt++;
		                break;
		            }
		            else if(i == k) {
		                i++;
		            }
		            else if(j == k) {
		                j--;
		            }
		        }
		        else if(arr[i] + arr[j] < find) {
	                i++;
	            } else {
	                j--;
	            }
		    }
		}
		System.out.println(cnt);
		br.close();
	}
}