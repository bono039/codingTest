import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
    static int[] arr;
    static boolean[] visited = new boolean[20 * 1000000 + 10];
    
    static int answer = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);

        for(int i = 1 ; i < visited.length ; i++) {
            if(!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }
    
    private static void dfs(int depth, int sum) {
        if(depth == N) {
            visited[sum] = true;
            return;
        }
        
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
    
}