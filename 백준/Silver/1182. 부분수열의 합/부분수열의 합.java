import java.util.*;
import java.io.*;

public class Main {
    static int N, goal, ans;
    static int[] A;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        System.out.println(ans);
    }
    
    private static void dfs(int i, int cnt) {
        if(i == N)  return;
        else {
            if(A[i] + cnt == goal) {
                ans++;
            }
            
            dfs(i + 1, cnt);
            dfs(i + 1, cnt + A[i]);
        }
    }
}
