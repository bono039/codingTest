import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[][] map;
    static int[] plan;
    static boolean isPossible;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    parent[i] = i;
		}
		
		map = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 1 ; j <= N ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		        
		        if(map[i][j] == 1) {
		            union(i,j);
		        }
		    }
		}
		
		plan = new int[M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1 ; i <= M ; i++) {
		    plan[i] = Integer.parseInt(st.nextToken());
		}
		
		isPossible = true;
		for(int i = 1 ; i < plan.length ; i++) {
		    if(find(plan[i]) != find(plan[1])) {
		        isPossible = false;
		        break;
		    }
		}
		System.out.println(isPossible ? "YES" : "NO");
	}
	
	static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b) parent[b] = a;
	}
	static int find(int a) {
	    if(a == parent[a]) return a;
	    return parent[a] = find(parent[a]);
	}
}
