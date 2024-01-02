import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }
        
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            A[s].add(e);
            A[e].add(s);
        }
        
        for(int i = 1 ; i<= N ; i++) {
            Collections.sort(A[i]);
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(sb1);
        
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb2);
    }
    
    private static void dfs(int v) {
        sb1.append(v).append(" ");
        visited[v] = true;
        
        for(int n : A[v]) {
            if(!visited[n]) {
                dfs(n);
            }
        }
    }
    
    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb2.append(now).append(" ");
            
            for(int n : A[now]) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }            
        }
    }
}