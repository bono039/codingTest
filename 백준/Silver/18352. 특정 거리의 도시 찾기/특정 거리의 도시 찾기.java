import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K ,X;
    static List<Integer> answer;    // 정답 리스트
    static ArrayList<Integer>[] A;  // 인접 리스트
    static int[] visited;           // 방문 배열
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());   // 도시 개수
		M = Integer.parseInt(st.nextToken());   // 도로 개수
		K = Integer.parseInt(st.nextToken());   // 거리 정보
		X = Integer.parseInt(st.nextToken());   // 출발 도시 번호
		
		answer = new ArrayList<>(); // 정답 리스트
		
		// 인접 리스트의 각 ArrayList 초기화
		A = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<Integer>();
		}
		
		// 인접 리스트 채우기
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    
		    A[S].add(E);
		}
		
        // 방문 배열 초기화
		visited = new int[N + 1];
		for(int i = 0 ; i <= N ; i++) {
		    visited[i] = -1;
		}
		
		BFS(X);
		
		for(int i = 0 ; i <= N ; i++) {
		    if(visited[i] == K) {
		        answer.add(i);
		    }
		}
		
		if(answer.isEmpty()) {
		    System.out.println(-1);
		}
		else {
		    Collections.sort(answer);
		    for(int a : answer) {
		        System.out.println(a);
		    }
		}
	}
	
	// BFS
	public static void BFS(int node) {
	    Queue<Integer> q = new LinkedList<>();
	    q.add(node);
	    visited[node]++;
	    
	    while(!q.isEmpty()) {
	        int now_node = q.poll();
	        
	        for(int i : A[now_node]) {
	            if(visited[i] == -1) {
	                visited[i] = visited[now_node] + 1;
	                q.add(i);
	            }
	        }
	    }  
	}
}