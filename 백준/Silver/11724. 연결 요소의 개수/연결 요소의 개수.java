import java.util.*;
import java.io.*;

public class Main {
    static int N, M, cnt;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }
        
        visited = new boolean[N + 1];
        
        while(M -- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
        
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());     
            
            A[u].add(v);
            A[v].add(u);
        }
        
        for(int i = 1 ; i <= N ; i++) {
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : A[now]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}