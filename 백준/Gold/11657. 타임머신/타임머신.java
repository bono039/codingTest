import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    
    static Edge[] edges;        // 에지 리스트
    static long[] distance;     // 최단 경로 배열
    static boolean isCycle = false;     // 음수 사이클 여부 판단
    static long INF = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 변수들 초기화
		edges = new Edge[M + 1];
		
		distance = new long[N + 1];
		distance[1] = 0;
		for(int i = 2 ; i <= N ; i++) {
		    distance[i] = INF;
		}
		
		// 버스 노선 정보 입력 받기
		for(int i = 1 ; i <= M ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());

		    edges[i] = new Edge(a, b, c);
		}
		
		// 1. 거리 배열 값 업데이트 (노드 개수 - 1번 반복)
		for(int i = 1 ; i < N ; i++) {
		    for(int j = 1 ; j <= M ; j++) {
		        Edge edge = edges[j];

		        if(distance[edge.s] != INF && distance[edge.e] > distance[edge.s] + edge.t) {
		            distance[edge.e] = distance[edge.s] + edge.t;
		        }
		    }
		}
		
		
		// 2. 음수 사이클 유무 판단
		for(int i = 1 ; i <= M ; i++) {
		    Edge edge = edges[i];
		    
		    if(distance[edge.s] != INF && distance[edge.e] > distance[edge.s] + edge.t) {
		        isCycle = true;
		        break;
		    }
		}
		
		if(!isCycle) {
		    for(int i = 2 ; i <= N ; i++) {
		        sb.append(distance[i] == INF ? "-1" : distance[i]).append("\n");
		    }
		}
		else {
		    sb.append("-1").append("\n");
		}
		System.out.print(sb);
	}
}

class Edge {
    int s, e, t;
    
    public Edge(int s, int e, int t) {
        this.s = s;
        this.e = e;
        this.t = t;
    }
}