import java.util.*;
import java.io.*;

public class Main {
    
    static int[] arr;
    static boolean[] visited, done;
    
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());
            
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            cnt = 0;
            
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1 ; i <= N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 1 ; i <= N ; i++) {
                if(!done[i]) {
                    dfs(i);
                }
            }
            
            sb.append(N - cnt).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    private static void dfs(int num) {
        if(visited[num]) {
            done[num] = true;
            cnt++;
        }
        else {
            visited[num] = true;
        }
        
        if(!done[arr[num]]) {
            dfs(arr[num]);
        }
        
        visited[num] = false;
        done[num] = true;
    }
}