import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;  // 인접 리스트
    static int[] check;             // 이분 그래프 체크 배열
    static boolean[] visited;       // 방문 배열
    static boolean isEven;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		while(K --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int V = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    
		    A = new ArrayList[V + 1];
		    for(int j = 1 ; j <= V ; j++) {
		        A[j] = new ArrayList<>();
		    }

		    visited = new boolean[V + 1];
		    check = new int[V + 1];
		    
		    while(E --> 0) {
		        st = new StringTokenizer(br.readLine(), " ");
		        int s = Integer.parseInt(st.nextToken());
		        int e = Integer.parseInt(st.nextToken());
		        
		        A[s].add(e);
		        A[e].add(s);
		    }
		    
		    // 🔔 모든 노드에서 수행 🔔
		    isEven = true;
		    for(int i = 1 ; i <= V ; i++) {
		        if(isEven)  dfs(i);
		        else        break;
		    }
		    
		    System.out.println(isEven ? "YES" : "NO");
		}
	}
	
	static void dfs(int idx) {
	    visited[idx] = true;
	    
	    for(int next : A[idx]) {
	        if(!visited[next]) {
	            // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리 (= 이분 그래프)
	            check[next] = (check[idx] + 1) % 2;
	            dfs(next);
	        }
	        // 🔔 이미 방문한 노드가 현재 내 노드와 같은 집합이면, 이분 그래프 X 🔔
	        else if(check[idx] == check[next]) {
	            isEven = false;
	        }
	    }
	}
}
