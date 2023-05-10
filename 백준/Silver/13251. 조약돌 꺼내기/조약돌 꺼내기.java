import java.util.*;
import java.io.*;

public class Main {
    static int M, K, T;
    static int[] D = new int[51];
    static double probability[] = new double[51];
    static double ans;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		
        st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < M ; i++) {
		    D[i] = Integer.parseInt(st.nextToken());
		    T += D[i];
		}

		K = Integer.parseInt(br.readLine());
		ans = 0.0;
		
		for(int i = 0 ; i < M ; i++) {
		    if(D[i] >= K) {
		        probability[i] = 1.0;
		        
		        for(int k = 0 ; k < K ; k++) {
		            probability[i] *= (double) (D[i] - k) / (T - k);
		        }
		    }
		    ans += probability[i];
		}
		System.out.println(ans);
		br.close();
	}
}