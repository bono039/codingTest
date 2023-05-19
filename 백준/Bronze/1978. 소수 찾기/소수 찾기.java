import java.util.*;
import java.io.*;
 
public class Main {
    public static final int MAX = 1001;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 에라토스테네스의 체
        boolean[] isPrime = new boolean[MAX];
        for(int i = 2 ; i < MAX ; i++) {
            isPrime[i] = true;
        }
    
        for(int i = 2 ; i <= Math.sqrt(MAX) ; i++) {
	        for(int j = i * i ; j < MAX ; j += i) {
	            if(!isPrime[j]) continue;
	            isPrime[j] = false;
	        }
	    }

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i < n ; i++) {
		    int x = Integer.parseInt(st.nextToken());
		    if(isPrime[x]) cnt++;
		}
		
		System.out.println(cnt);
	}
}