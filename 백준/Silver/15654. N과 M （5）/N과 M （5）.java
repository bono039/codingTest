import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        numbers = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        
        dfs(0);
        System.out.println(sb);
    }
    
    private static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0 ; i < M ; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0 ; i < N ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}