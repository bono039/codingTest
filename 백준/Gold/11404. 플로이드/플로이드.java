import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] distance;
    static int max = 10000001;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		distance = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        if(i == j) distance[i][j] = 0;
		        else       distance[i][j] = max;
		    }
		}
		
		for(int i = 1 ; i <= M ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    int K = Integer.parseInt(st.nextToken());
		    
		    if(distance[S][E] > K) distance[S][E] = K;
		}
		
		for(int K = 1 ; K <= N ; K++) {
		    for(int i = 1 ; i <= N ; i++) {
		        for(int j = 1 ; j <= N ; j++) {
                    if(distance[i][j] > distance[i][K] + distance[K][j])
                        distance[i][j] = distance[i][K] + distance[K][j];
		        }
		    }
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        if(distance[i][j] == max) System.out.print("0 ");
		        else                           System.out.print(distance[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}