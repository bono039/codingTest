import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    
    static int min;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++) {
            visited[i] = true;
            tsp(i, i, 0, 0);
        }
        
        System.out.println(min);
    }
    
    private static void tsp(int start, int now, int sum, int cnt) {
        if(cnt == N - 1) {
            if(map[now][start] != 0) {
                sum += map[now][start];
                min = Math.min(min, sum);
            }
            return;
        }
        
        for(int i = 0 ; i < N ; i++) {
            if(!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                tsp(start, i, sum + map[now][i], cnt + 1);
                visited[i] = false;
            } 
        }
    }
}