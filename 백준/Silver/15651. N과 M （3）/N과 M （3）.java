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
        
        dfs(0);
        System.out.println(sb);
    }
    
    public static void dfs(int depth) {
        if(depth == M) {
            for(int val : A) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0 ; i < N ; i++) {
            A[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}