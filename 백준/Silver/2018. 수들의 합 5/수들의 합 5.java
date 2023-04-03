import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int start_idx = 1;
		int end_idx = 1;
		int cnt = 1;    // 가지수
		int sum = 1;
		
		while(end_idx != N) {
		    if(sum == N) {  // 현재 연속 합이 N과 같은 경우
		        cnt++;
		        end_idx++;
		        sum += end_idx;
		    }
		    else if(sum < N) {
		        end_idx++;
		        sum += end_idx;
		    }
		    else if(sum > N) {
		        sum -= start_idx;
		        start_idx++;
		    }
		}
		System.out.println(cnt);
	}
}