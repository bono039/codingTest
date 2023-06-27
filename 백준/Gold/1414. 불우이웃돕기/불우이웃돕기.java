import java.util.*;
import java.io.*;

public class Main {
    static int N, sum;
    static PriorityQueue<Edge> pq;
    static int[] parent;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		parent = new int[N];
		for(int i = 0 ; i < N ; i++)
		    parent[i] = i;
		
		pq = new PriorityQueue<>();

		for(int i = 0 ; i < N ; i++) {
		    char[] chArr = br.readLine().toCharArray();
		    
		    for(int j = 0 ; j < chArr.length ; j++) {
		        int tmp = 0;
		        
		        if('a' <= chArr[j] && chArr[j] <= 'z') {
		            tmp = chArr[j] - 'a' + 1;
		        }
		        else if('A' <= chArr[j] && chArr[j] <= 'Z') {
		            tmp = chArr[j] - 'A' + 27;
		        }
		        sum += tmp;
		        
		        if(i != j && tmp != 0) {
		            pq.add(new Edge(i, j, tmp));
		        }
		    }
		}
		
		int useEdge = 0;
		int result = 0;
		
		while(!pq.isEmpty()) {
		    Edge now = pq.poll();
		    
		    if(find(now.s) != find(now.e)) {
		        union(now.s, now.e);
		        result += now.v;
		        useEdge++;
		    }
		}
		
		System.out.println((useEdge == N - 1) ? (sum - result) : -1);
	}
	
	private static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b)  parent[b] = a;
	}
	private static int find(int a) {
	    if(a == parent[a])  return a;
	    return parent[a] = find(parent[a]);
	}
}

class Edge implements Comparable<Edge> {
    int s, e, v;
    
    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(Edge edge) {
        return this.v - edge.v;
    }
}
