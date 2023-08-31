import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int N, ans;
    static int[][] map;
    static boolean[][] visited;
    
    static PriorityQueue<Integer> list = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    ans++;
                    
                    int tmp = bfs(i, j);
                    list.add(tmp);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        
        while(!list.isEmpty()) {
            sb.append(list.poll()).append("\n");
        }
        System.out.println(sb);
    }
    
    private static int bfs(int a, int b) {
        int cnt = 1;
        visited[a][b] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int newX = now[0] + dx[d];
                int newY = now[1] + dy[d];
                
                if(newX < 0 || newY < 0 || newX >= N || newY >= N)  continue;
                if(visited[newX][newY] || map[newX][newY] == 0) continue;
                
                if(!visited[newX][newY] && map[newX][newY] != 0) {
                    visited[newX][newY] = true;
                    queue.add(new int[] {newX, newY});
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}