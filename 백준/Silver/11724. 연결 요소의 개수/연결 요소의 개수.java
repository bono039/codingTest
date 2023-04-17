import java.util.*;
import java.io.*;

public class Main {
    static boolean visited[];
	static ArrayList<Integer>[] A;    
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());   // 정점
		int m = Integer.parseInt(st.nextToken());   // 간선
	    
	    // 방문 기록 저장 배열
	    visited = new boolean[n+1];
	    
	    // 그래프 데이터 저장 인접 리스트
	    A = new ArrayList[n+1];   
	    
	    // A 인접 리스트의 각 ArrayList 초기화하기
	    for(int i=1 ; i < n+1 ; i++) {
	        A[i] = new ArrayList<Integer>();
	    }
	    
	    // A 인접 리스트에 그래프 데이터 저장하기
	    for(int i=0 ; i < m ; i++) {
	        st = new StringTokenizer(br.readLine());
	        int start = Integer.parseInt(st.nextToken());
	        int end   = Integer.parseInt(st.nextToken());
	        
	        // 양쪽 방향으로 다 더해주기
	        A[start].add(end);
	        A[end].add(start);
	    }
	    
	    int count = 0;
	    
	    // 0번은 안 씀!
	    for(int i=1 ; i < n+1 ; i++) {
	        if(!visited[i]) {
	            count++;
	            DFS(i);
	        }
	    }
	    System.out.println(count);
	}
	
	// DFS 구현
	private static void DFS(int v) {
	    // 현재 노드가 방문 노드인 경우
	    if(visited[v]) return;
	    visited[v] = true;
	    
	    
	    // 현재 연결 노드 중 방문하지 않은 노드로 DFS 실행
	    // ArrayList 실행
	    for(int i : A[v]) {
	        if(!visited[i]) {
	            DFS(i); // 재귀함수
	        }
	    }
	}
}