import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;   // 방문 배열
    static ArrayList<Integer>[] A;
    static boolean arrive;      // 도착 여부
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());   // 사람 수
		int M = Integer.parseInt(st.nextToken());   // 친구 관계 수
		
		visited = new boolean[N];   // 방문 배열
		A = new ArrayList[N];       // 그래프 데이터 저장 인접 리스트
		arrive = false;             // 도착 여부
		
		// 인접 리스트 초기화
		for(int i = 0 ; i < N ; i++) {
		    A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    A[a].add(b);
		    A[b].add(a);
		}

		
		for(int i = 0 ; i < N ; i++) {
		    DFS(i, 1);      // depth 1부터 시작

		    if(arrive)
		        break;
		}
		
		if(arrive) System.out.println("1");
		else       System.out.println("0");
	}
	
	// DFS 구현
	static void DFS(int now, int depth) {
	    if(depth == 5 || arrive) {    // depth가 5가 되면 종료
	        arrive = true;
	        return;
	    }
	    
	    visited[now] = true;
	    for(int i : A[now]) {
	        if(!visited[i]) {
	            DFS(i, depth + 1);  // 재귀 호출 돌 때마다 depth 1씩 증가
	        }
	    }
	    visited[now] = false;
	}
}