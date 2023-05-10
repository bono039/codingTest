import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long[][] bridge = new long[31][31];
		for(int i = 0 ; i <= 30 ; i++) {
		    bridge[i][0] = 1;
		    bridge[i][1] = i;
		    bridge[i][i] = 1;
		}
		
		for(int i = 2 ; i <= 30 ; i++) {
		    for(int j = 1 ; j < i ; j++) {
		        bridge[i][j] = bridge[i - 1][j] + bridge[i - 1][j - 1];
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
		    st = new StringTokenizer(br.readLine()," ");
        	int N = Integer.parseInt(st.nextToken());   // 서
        	int M = Integer.parseInt(st.nextToken());   // 동
        	
        	sb.append(bridge[M][N] + "\n");
		}
		
        System.out.println(sb);
        br.close();
	}
}