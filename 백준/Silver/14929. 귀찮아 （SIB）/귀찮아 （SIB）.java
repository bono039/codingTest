import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1 ; i <= N ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		    sum[i] = sum[i - 1] + arr[i];
		}
		
		long ans = 0;
		for(int i = 1 ; i < N ; i++) {
		    int val = getSum(i + 1, N, sum);
		    ans += val * arr[i];
		}
		
		System.out.println(ans);
	}
	
    private static int getSum(int l, int r, int[] sum) {
        return sum[r] - sum[l - 1];
    }
}
