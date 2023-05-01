import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] D;
    static ArrayList<Node>[] A;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		D = new int[N+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		A = new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		while(M --> 0) {
		    st = new StringTokenizer(br.readLine()," ");
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    int V = Integer.parseInt(st.nextToken());
		    
		    A[S].add(new Node(E, V));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
        System.out.println(dijkstra(startCity, endCity));
	}
	
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        D[start] = 0;
        
        while(!pq.isEmpty()) {
            Node nowNode = pq.poll();
            
            if(!visited[nowNode.node]) {
                visited[nowNode.node] = true;

                for(Node next : A[nowNode.node]) {
                    if(!visited[next.node] && D[next.node] > D[nowNode.node] + next.value) {
                        D[next.node] = D[nowNode.node] + next.value;
                        pq.add(new Node(next.node, D[next.node]));
                    }
                }
            }
        }
        return D[end];
    }
}

class Node implements Comparable<Node>{
    int node, value;
    
    Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
    
    @Override
    public int compareTo(Node e) {
        return this.value - e.value;
    }
}