import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static int INF = Integer.MAX_VALUE;
    
    static ArrayList<Node>[] A; // 인접 리스트
    
    static int[] D;             // 최단 거리 배열
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());   // 정점
		E = Integer.parseInt(st.nextToken());   // 간선
		
		K = Integer.parseInt(br.readLine());    // 시작 정점
		
		// 인접 리스트 초기화
		A = new ArrayList[V + 1];
		for(int i = 1 ; i <= V ; i++) {
		    A[i] = new ArrayList<>();
		}

		// 최단 거리 배열 초기화
		D = new int[V + 1];
		Arrays.fill(D, INF);
		D[K] = 0;
		
		while(E --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    
		    A[u].add(new Node(v, w));
		}
		
		dijkstra(K);
		
		for(int i = 1 ; i < D.length ; i++) {
		    sb.append(D[i] == INF ? "INF" : D[i]).append("\n");
		}
		
        System.out.println(sb);
	}
	
	private static void dijkstra(int num) {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(num, 0));   // 큐에 탐색 시작점 추가
		
		while(!pq.isEmpty()) {
		    Node now = pq.poll();
		    
		    for(Node next : A[now.node]) {
		        if(D[next.node] > D[now.node] + next.cost) {
		            D[next.node] = D[now.node] + next.cost;
		            pq.add(new Node(next.node, D[next.node]));
		        }
		    }
		}	    
	}
}


class Node implements Comparable<Node> {
    int node, cost;
    
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    // 우선순위 큐에서 사용 시 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}
