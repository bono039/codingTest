import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i = 0 ; i < N ; i++) {
            A[i] = i + 1;
        }
        result = new int[N];
        visited = new boolean[N];
        
        back(0);
        System.out.println(sb);
    }
    
    private static void back(int depth) {
        if(depth == N) {
            for(int i : result) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = 0 ; i < N ; i++) {
            if(!visited[i]) {
                result[depth] = A[i];
                
                visited[i] = true;
                back(depth + 1);
                visited[i] = false;
            }
        }
    }
}