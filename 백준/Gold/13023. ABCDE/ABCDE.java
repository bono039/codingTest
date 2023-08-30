import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean flag;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N];
        for(int i = 0 ; i < N ; i++) {
            A[i] = new ArrayList<>();
        }
        
        visited = new boolean[N];
        flag = false;
        
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            A[a].add(b);
            A[b].add(a);
        }
        
        for(int i = 0 ; i < N ; i++) {
            dfs(i, 1);
            
            if(flag) break;
        }
        
        System.out.println(flag ? 1 : 0);
    }
    
    private static void dfs(int startIdx, int depth) {
        if(depth == 5 || flag) {
            flag = true;
            return;
        }
        
        visited[startIdx] = true;
        
        for(int next : A[startIdx]) {
            if(!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        
        visited[startIdx] = false;
    }
}