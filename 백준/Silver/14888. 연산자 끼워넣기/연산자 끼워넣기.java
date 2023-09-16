import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A;
    static int[] signs = new int[4];
    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 4 ; i++) {
            signs[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(A[0], 1);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void dfs(int num, int idx) {
        if(idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++) {
            if(signs[i] > 0) {
                signs[i]--;
                
                switch(i) {
                    case 0 : dfs(num + A[idx], idx + 1);    break;
                    case 1 : dfs(num - A[idx], idx + 1);    break;
                    case 2 : dfs(num * A[idx], idx + 1);    break;
                    case 3 : dfs(num / A[idx], idx + 1);    break;
                }
                
                signs[i]++;
            } 
        }
    }
}