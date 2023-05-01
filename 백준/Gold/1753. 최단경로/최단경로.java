import java.util.*;
import java.io.*;

public class Main {
    public static int V, E, K;
    public static int[] D;         // 최단 거리 배열
    public static boolean visited[]; // 방문 배열
    
    public static ArrayList<ArrayList<Edge>> A; // 인접 리스트
    public static PriorityQueue<Edge> pq = new PriorityQueue<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());   // 정점
		E = Integer.parseInt(st.nextToken());   // 간선
		
		K = Integer.parseInt(br.readLine());    // 시작점
		
		// 최단 거리 배열
		D = new int[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		// 인접 리스트
		A = new ArrayList<>();
		for(int i = 0 ; i <= V ; i++) {
		    A.add(new ArrayList<>());
		}
		
		for(int i = 1 ; i <= E ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    
		    A.get(u).add(new Edge(v, w));
		}
		
		visited = new boolean[V + 1];
		pq.add(new Edge(K, 0)); // K를 시작점으로 설정
		D[K] = 0;
		
		while(!pq.isEmpty()) {
		    Edge current = pq.poll();
		    int c_ver = current.vertex;
		    if(visited[c_ver]) continue;    // 중복 방지
		    visited[c_ver] = true;
		    
		    for(int i = 0 ; i < A.get(c_ver).size() ; i++) {
		        Edge tmp = A.get(c_ver).get(i);
		        
		        int next  = tmp.vertex;
		        int value = tmp.value;
		        
		        // 최소 거리로 업데이트
		        if(D[next] > D[c_ver] + value) {
		            D[next] = D[c_ver] + value;
		            pq.add(new Edge(next, D[next]));
		        }
		    }
		}
		
		for(int i = 1 ; i <= V ; i++) {
		    if(visited[i])
		        System.out.println(D[i]);
		    else
		        System.out.println("INF");
		}
	}
}

class Edge implements Comparable<Edge> {
    int vertex, value;
    
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value  = value;
    }
    
    public int compareTo(Edge e) {
        if(this.value > e.value) return 1;
        else    return -1;
    }
}