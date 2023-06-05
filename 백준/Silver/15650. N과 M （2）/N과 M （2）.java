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
    
    public static void dfs(int at, int depth) {
        if(depth == M) {
            for(int val : A) {
                System.out.print(val +" ");
            }
            System.out.println();
            return;
        }
        
        for(int i = at ; i <= N ; i++) {
            A[depth] = i;
            dfs(i + 1, depth + 1);
        } 
    }
}