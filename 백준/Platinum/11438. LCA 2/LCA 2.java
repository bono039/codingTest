import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;

    static int[] depth;
    static int[][] parent;
    
    static ArrayList<Integer>[] tree;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
	
		K = 0;
		for(int i = 1 ; i <= N ; i *= 2) {
		    K++;
		}
		
		depth  = new int[N + 1];
		parent = new int[K][N + 1];
		
		tree = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    tree[i] = new ArrayList<>();
		}
		
		for(int i = 1 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
		    tree[s].add(e);
		    tree[e].add(s);
		}
		
		DFS(1, 1);
		fillParent();
		
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
		    sb.append(LCA(s, e) + "\n");
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void DFS(int node, int cnt) {
	    depth[node] = cnt;
	    
	    for(int next : tree[node]) {
	        if(depth[next] == 0) {
	            parent[0][next] = node;    // 첫번째 부모 기록
	            DFS(next, cnt + 1);
	        }
	    }
	}
	
	static void fillParent() {
	    for(int i = 1 ; i < K ; i++) {
	        for(int j = 1 ; j <= N ; j++) {
	            parent[i][j] = parent[i-1][parent[i-1][j]];
	        }
	    }
	}
	
	static int LCA(int a, int b) {
	    if(depth[a] < depth[b]) {
	        int tmp = a;
	        a = b;
	        b = tmp;
	    }
	    
	    for(int i = K - 1 ; i >= 0 ; i--) {
	        if(Math.pow(2, i) <= depth[a] - depth[b]) {
	            a = parent[i][a];
	        }
	    }
	    
	    if(a == b) return a;
	    
	    for(int i = K - 1 ; i >= 0 ; i--) {
	        if(parent[i][a] != parent[i][b]) {
	            a = parent[i][a];
	            b = parent[i][b];
	        }
	    }
	    return parent[0][a];
	}
}