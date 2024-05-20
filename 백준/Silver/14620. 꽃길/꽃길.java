import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N;
    static int[][] board;
    static boolean[][] visited;
    
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       
        dfs(0, 0);
        System.out.println(answer);
    }
   
    private static void dfs(int cnt, int sum) {
        if(cnt == 3) {
            answer = Math.min(answer, sum);
            return;
        }
       
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(isPossible(i,j)) {
                    int tmpSum = getSum(i, j);
                   
                    visited[i][j] = true;
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        visited[nx][ny] = true;
                    }
                   
                    dfs(cnt + 1, sum + tmpSum);
                   
                    visited[i][j] = false;
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                       
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
   
    private static boolean isPossible(int x, int y) {
        if(visited[x][y])   return false;
       
        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)  return false;
            if(visited[nx][ny]) return false;
        }
       
       return true;
    }
   
    private static int getSum(int x, int y) {
        int sum = board[x][y];
        
        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            sum += board[nx][ny];
        }
        
        return sum;
    }
}