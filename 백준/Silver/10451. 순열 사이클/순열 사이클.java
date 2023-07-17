import java.util.*;
import java.io.*;

public class Main {
    static int T, N, cnt;
    static int[] A;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            N = Integer.parseInt(br.readLine());
            
            // 변수들 초기화
            A = new int[N + 1];
            visited = new boolean[N + 1];
            cnt = 0;
            
            // 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1 ; i <= N ; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 1 ; i <= N ; i++) {
                if(!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        
        System.out.println(sb);
    }
    
    private static void dfs(int num) {
        if(visited[num])    return;
        
        visited[num] = true;
        
        if(!visited[A[num]]) {
            dfs(A[num]);
        }
        else {
            return;
        }
    }
}