import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M, x1, y1, x2, y2;
    static char[][] map;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine() ," ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new char[N][M];
	    visited = new boolean[N][M];
	    
	    st = new StringTokenizer(br.readLine() ," ");
	    x1 = Integer.parseInt(st.nextToken()) - 1;
	    y1 = Integer.parseInt(st.nextToken()) - 1;
	    x2 = Integer.parseInt(st.nextToken()) - 1;
	    y2 = Integer.parseInt(st.nextToken()) - 1;
	    
	    for(int i = 0 ; i < N ; i++) {
	        String str = br.readLine();
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = str.charAt(j);
	        }
	    }
	    
	    System.out.println(dijkstra());
	}
	
	private static int dijkstra() {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(x1, y1, 0));
	    
	    visited[x1][y1] = true;
	    
	    while(!pq.isEmpty()) {
	        Node now = pq.poll();
	        
	        if(now.x == x2 && now.y == y2) return now.w;
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now.x + dx[d];
	            int ny = now.y + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])  continue;
	            
	            visited[nx][ny] = true;
	            pq.add(new Node(nx, ny, map[nx][ny] == '0' ? now.w : now.w +1));
	        }
	    }
	    
	    return 0;
	}
}

class Node implements Comparable<Node> {
    int x, y, w;
    
    public Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.w - n.w;
    }
}
