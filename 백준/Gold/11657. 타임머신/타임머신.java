import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] D;    // 최단 경로 배열
    static Edge[] edges;// 에지 리스트
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		D = new long[N + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		
		edges = new Edge[M + 1];
		for(int i = 1 ; i <= M ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    int time = Integer.parseInt(st.nextToken());
		    
		    edges[i] = new Edge(start, end, time);
		}
		
		for(int i = 1 ; i < N ; i++) {
		    for(int j = 1 ; j <= M ; j++) {
		        Edge edge = edges[j];
		        
		        if(D[edge.start] != Integer.MAX_VALUE && D[edge.end] > D[edge.start] + edge.time) {
		            D[edge.end] = D[edge.start] + edge.time;
		        }
		    }
		}
		
		boolean isCycle = false;
		for(int i = 1 ; i <= M ; i++) {
		    Edge edge = edges[i];
		    if(D[edge.start] != Integer.MAX_VALUE && D[edge.end] > D[edge.start] + edge.time) {
		        isCycle = true;
		        break;
		    }   
		}
		
		if(!isCycle) {
            for(int i = 2 ; i <= N ; i++) {
                if(D[i] == Integer.MAX_VALUE) System.out.println("-1");
                else                          System.out.println(D[i]);
            }
		}
		else {
		    System.out.println("-1");
		}
	}
}

class Edge {
    int start, end, time;
    
    Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}