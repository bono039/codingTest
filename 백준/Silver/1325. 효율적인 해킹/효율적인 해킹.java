import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean visited[];       // 방문 배열
    static ArrayList<Integer>[] A;  // 인접 리스트
    static int answer[];            // 정답 배열
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		answer = new int[N + 1];
		// 인접 리스트 채우기
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}		
		for(int i = 0 ; i < M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    
		    A[S].add(E);
		}
	
		// 모든 노드에 대해 BFS 수행
		for(int i = 1 ; i <= N ; i++) {
		    visited = new boolean[N + 1];
		    BFS(i);
		}
		
		int maxVal = 0;
		for(int i = 1 ; i <= N ; i++) {
		    maxVal = Math.max(maxVal, answer[i]);
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    if(answer[i] == maxVal) {
		        System.out.print(i + " ");
		    }
		}
	}
	
	public static void BFS(int node) {
	    visited[node] = true;
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(node);
	    
	    while(!queue.isEmpty()) {
	        int now_node = queue.poll();
	        
            for(int i : A[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    answer[i]++;    // 신규 노드 인덱스의 정답 배열 값 증가시킴
                    queue.add(i);
                }
            }	        
	    }
	}
}