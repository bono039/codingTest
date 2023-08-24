import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N];
        
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combi(0, 0);
        System.out.println(min);
    }
    
    private static void combi(int depth, int idx) {
        if(depth == N / 2) {
            diff();
            return;
        }
        
        for(int i = idx ; i < N ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(depth + 1, i + 1);
                visited[i] = false;                
            }
        }
    }

    private static void diff() {
        int teamS = 0;
        int teamL = 0;
        
        for(int i = 0 ; i < N - 1 ; i++) {
            for(int j = i + 1 ; j < N ; j++) {
                if(visited[i] && visited[j]) {
                    teamS += map[i][j];
                    teamS += map[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    teamL += map[i][j];
                    teamL += map[j][i];
                }
            }
        }
        
        int diff = Math.abs(teamS - teamL); 
        if(diff == 0) {
            System.out.println(0);
            System.exit(0);
        }
        
        min = Math.min(min, diff);
    }
}