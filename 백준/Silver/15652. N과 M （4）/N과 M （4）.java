import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] A;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[M];
        visited = new boolean[N];
        
        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        if(depth == M) {
            for(int val : A) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = at ; i <= N ; i++) {
            A[depth] = i;
            dfs(i, depth + 1);
        }
    }
}