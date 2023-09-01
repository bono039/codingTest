import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int x, y, val;
    
    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int M, N;
    static int min = Integer.MAX_VALUE;
    
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        
        for(int i = 1 ; i <= N ; i++) {
            String str = br.readLine();
            for(int j = 1 ; j <= M ; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }
        
        System.out.println(bfs(1, 1));
    }
    
    private static int bfs(int a, int b) {
        visited[a][b] = true;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a, b, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.x == N && now.y == M) {
                return now.val;
            }
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(nx < 1 || ny < 1 || nx > N || ny > M || visited[nx][ny])   continue;
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    
                    if(map[nx][ny] == 0) {
                        pq.add(new Node(nx, ny, now.val));
                    }
                    else {
                        pq.add(new Node(nx, ny, now.val + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}