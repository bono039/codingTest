import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] distance;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		distance = new int[N + 1][N + 1];
		
		for(int i = 1 ; i <= N ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    for(int j = 1 ; j <= N ; j++) {
		        distance[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		for(int k = 1 ; k <= N ; k++) {
		    for(int i = 1 ; i <= N ; i++) {
		        for(int j = 1 ; j <= N ; j++) {
		            if(distance[i][k] == 1 && distance[k][j] == 1)  distance[i][j] = 1;
		        }
		    }
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        System.out.print(distance[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}