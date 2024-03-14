import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] A;
    static boolean[] robot;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    A = new int[2*N];
	    robot = new boolean[N];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < 2 * N ; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    System.out.println(simulate());
	}
	
	private static int simulate() {
	    int cnt = 0;
	    
        while(cntZero() < K) {
	        int tmp = A[A.length - 1];
            for(int i = A.length - 1 ; i >= 1 ; i--) {
                A[i] = A[i - 1];
            }
            A[0] = tmp;
        
    	    for(int i = robot.length - 1 ; i >= 1 ; i--) {
    	        robot[i] = robot[i - 1];
    	    }
    	    robot[0] = false;
    	    robot[N - 1] = false;
            
            for(int i = robot.length - 1 ; i >= 1 ; i--) {
                if(robot[i - 1] && !robot[i] && A[i] >= 1) {
                    A[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }
            
            if(A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }
            
            cnt++;
        }
        
        return cnt;
	}
	
	private static int cntZero() {
	    int zero = 0;
	    for(int i : A) {
	        if(i == 0)
	            zero++;
	    }
	    
	    return zero;
	}
}
