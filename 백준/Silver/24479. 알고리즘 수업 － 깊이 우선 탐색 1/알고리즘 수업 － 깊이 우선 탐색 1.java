import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, cnt;
    
    static ArrayList<Integer>[] A;
    static int[] visited;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];
        for(int i = 1 ;  i <= N ; i++) {
            A[i] = new ArrayList<>();
        }
        
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            A[u].add(v);
            A[v].add(u);
        }
        
        for(int i = 1 ; i <= N ; i++) {
            Collections.sort(A[i]);
        }
        
        visited = new int[N + 1];
        cnt = 1;
        dfs(R);
        
        for(int i = 1 ; i < visited.length ; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);   
    }
    
    private static void dfs(int num) {
        visited[num] = cnt;
        
        for(int i = 0 ; i < A[num].size() ; i++) {
            int next = A[num].get(i);
            
            if(visited[next] == 0) {
                cnt++;
                dfs(next);
            }
        }
    }
}