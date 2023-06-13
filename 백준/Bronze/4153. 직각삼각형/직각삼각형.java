import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		    int[] A = new int[3];
		    
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    A[0] = Integer.parseInt(st.nextToken());
		    A[1] = Integer.parseInt(st.nextToken());
		    A[2] = Integer.parseInt(st.nextToken());
		    
		    if(A[0] == 0 && A[1] == 0 && A[2] == 0) {
		        System.out.println(sb);
		        return;
		    }
		    
		    Arrays.sort(A);
		    sb.append((A[0] * A[0] + A[1] * A[1] == A[2] * A[2]) ? "right" : "wrong").append("\n");
		}
	}
}