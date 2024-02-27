import java.util.*;
import java.io.*;

public class Main {
    static int N, tsScore, P;
    static int[] A;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    tsScore = Integer.parseInt(st.nextToken());
	    P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(1);
            return;
        }

        A = new int[N];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int answer = 0;
	    
	    if(N == P && tsScore <= A[A.length - 1]) {
            answer = -1;
	    }
	    else {
	        int rank = 1;
	        
	        for(int i = 0 ; i < N ; i++) {
	            if(tsScore < A[i])
	                rank++;
	            else
	                break;
	        }
	        
	        answer = rank;
	    }
	    
	    System.out.println(answer);
	}
}
