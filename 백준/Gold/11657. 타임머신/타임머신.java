import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    
    static Edge[] edges;
    static long[] distance;
    static boolean isCycle = false;
    static long INF = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edges = new Edge[M + 1];
		distance = new long[N + 1];
		distance[1] = 0;
		for(int i = 2 ; i <= N ; i++) {
		    distance[i] = INF;
		}

		for(int i = 1 ; i <= M ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());

		    edges[i] = new Edge(a, b, c);
		}
		
		for(int i = 1 ; i < N ; i++) {
		    for(int j = 1 ; j <= M ; j++) {
		        Edge edge = edges[j];

		        if(distance[edge.s] != INF && distance[edge.e] > distance[edge.s] + edge.t) {
		            distance[edge.e] = distance[edge.s] + edge.t;
		        }
		    }
		}
		
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