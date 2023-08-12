import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = arr[0];
		for (int i = 1; i < M; i++) {
			if(((arr[i] - arr[i - 1]) & 1) == 0) max = Math.max(max, (arr[i] - arr[i - 1]) / 2);
			else max = Math.max(max, (arr[i] - arr[i - 1]) / 2 + 1);
		}

		max = Math.max(max, N - arr[M - 1]);
		System.out.println(max);
	}
}