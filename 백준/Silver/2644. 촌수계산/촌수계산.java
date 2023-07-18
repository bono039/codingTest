import java.util.*;
import java.io.*;

public class Main {
    static int N, M, a, b, cnt;
    static ArrayList<Integer>[] A;
    static int[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(br.readLine());
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            A[x].add(y);
            A[y].add(x);
        }
        
        bfs(a, b);
        System.out.println(visited[b] == 0 ? -1 : visited[b]);
    }
    
    private static void bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(now == e)    return;
            
            for(int next : A[now]) {
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}