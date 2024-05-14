import java.util.*;

class Solution {    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N;
    static int[][] board;
    static int[][][] visited;
    
    public int solution(int[][] board) {
        this.board = board;
        N = board.length;
       
        visited = new int[N][N][4];
         
        return bfs();
    }
    
    private static int bfs() {
        int answer = Integer.MAX_VALUE;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,-1,0));
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if(now.r == N-1 && now.c == N-1) {
                answer = Math.min(answer, now.cost);
            }
            
            for(int d = 0 ; d < 4 ; d++) {
                int nr = now.r + dx[d];
                int nc = now.c + dy[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1)  continue;
                
                int nextCost = now.cost;
                if(now.dir == -1 || now.dir == d) {
                    nextCost += 100;
                }
                else {
                    nextCost += 600;
                }
                
                if(visited[nr][nc][d] == 0 || board[nr][nc] >= nextCost) {
                    q.add(new Node(nr, nc, d, nextCost));
                    visited[nr][nc][d] = 1;
                    board[nr][nc] = nextCost;
                }                
            }
        }
        
        return answer;
    }
}

class Node {
    int r, c, dir, cost;
    
    public Node(int r, int c, int dir, int cost) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cost = cost;
    }
}