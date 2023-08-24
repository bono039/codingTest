import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] A;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[M];
        
        dfs(1, 0);
        System.out.println(sb);
    }
    
    private static void dfs(int tmp, int depth) {
        if(depth == M) {
            for(int i : A)  sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = tmp ; i <= N ; i++) {
            A[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}