import java.util.*;
import java.io.*;
// 양방향 인접 행렬
// 중복 가능.
public class Main {
    static int N, M;
    static int INF = 10000001;
    static int[][] distance;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		distance = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    for(int j = 1 ; j <= N ; j++) {
		        if(i == j) distance[i][j] = 0;
		        else       distance[i][j] = INF;
		    }
		}
		
		for(int i = 1 ; i <= M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    distance[a][b] = distance[b][a] = 1;
		}
		
		for(int k = 1 ; k <= N ; k++) {
		    for(int i = 1 ; i <= N ; i++) {
		        for(int j = 1 ; j <= N ; j++) {
		            if(distance[i][j] > distance[i][k] + distance[k][j]) {
		                distance[i][j] = distance[i][k] + distance[k][j];
		            }
		        }
		    }
		}
		
		int min = Integer.MAX_VALUE;
		int answer = -1;

		for(int i = 1 ; i <= N ; i++) {
		    int tmp = 0;
		    
		    for(int j = 1 ; j <= N ; j++) {
		        tmp += distance[i][j];
		    }
		    if(min > tmp) {
		        min = tmp;
		        answer = i;
		    }
	    }
	    System.out.println(answer);
	}
}