import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		int[][] rgb = new int[N][3];
		
		int color = 0;
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    rgb[i][0] = Integer.parseInt(st.nextToken());
		    rgb[i][1] = Integer.parseInt(st.nextToken());
		    rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i < N ; i++) {
		    rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
		    rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
		    rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
		}
		
		System.out.println(Math.min(Math.min(rgb[N - 1][0], rgb[N - 1][1]), rgb[N - 1][2]));
	}
}