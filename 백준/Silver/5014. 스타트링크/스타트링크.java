import java.util.*;
import java.io.*;

public class Main {
    static int F,S,G,U,D;
    static int[] A;
    static int cnt = 0;
    static boolean isEnd = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        A = new int[F + 1];
        bfs(S);
        
        System.out.println(isEnd ? cnt : "use the stairs");
    }
    
    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        A[num] = 1;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(now == G) {
                isEnd = true;
                cnt = A[now] - 1;
                return;
            }
            
            if(now + U <= F) {
                if(A[now + U] == 0) {
                    A[now + U] = A[now] + 1;
                    queue.add(now + U);
                }
            }
            
            if(now - D > 0) {
                if(A[now - D] == 0) {
                    A[now - D] = A[now] + 1;
                    queue.add(now - D);
                }
            }
        }
    }
}