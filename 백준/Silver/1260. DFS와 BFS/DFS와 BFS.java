import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;  // 인접 리스트
    static boolean[] visited;       // 방문 배열

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());   // 정점
		int M = Integer.parseInt(st.nextToken());   // 간선
		int V = Integer.parseInt(st.nextToken());   // 탐색 시작점
		
		// 인접 리스트 A의 각 ArrayList 초기화
		A = new ArrayList[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
		    A[i] = new ArrayList<Integer>();
		}
		
		// 인접 리스트 채우기
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    A[a].add(b);
		    A[b].add(a);
		}
		
		// 번호가 작은 것 먼저 방문하기 위해 정렬
		for(int i = 1 ; i <= N ; i++) {
		    Collections.sort(A[i]);
		}
		
		visited = new boolean[N + 1];   // 방문 배열 초기화
	    DFS(V);
	    System.out.println();
	    
	    visited = new boolean[N + 1];   // 방문 배열 초기화
        BFS(V);
		System.out.println();
	}
	
	// DFS 구현 메소드
	static void DFS(int v) {
	    System.out.print(v + " ");	    
	    visited[v] = true;
	    
	    for(int i : A[v]) {
	        if(!visited[i]) {
	            DFS(i);
	        }
	    }
	}
	
	// BFS 구현 메소드
	static void BFS(int v) {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(v);
	    visited[v] = true;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        System.out.print(now + " ");
	        
	        for(int i : A[now]) {
	            if(!visited[i]) {
	                visited[i] = true;
	                queue.add(i);
	            }
	        }
	    }
	}
}