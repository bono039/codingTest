import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] A, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N];
        result = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        dfs(0, 0);
        System.out.println(sb);
    }
    
    private static void dfs(int at, int depth) {
        if(depth == M) {
            for(int i = 0 ; i < M ; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = at ; i < N ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = A[i];
                dfs(i, depth + 1);
                visited[i] = false;               
            }
        }
    }
}