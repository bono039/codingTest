import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] A, result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        
        result = new int[M];
        
        back(0, 0);
        System.out.println(sb);
    }
    
    private static void back(int startIdx, int depth) {
        if(depth == M) {
            for(int i : result) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = startIdx ; i < N ; i++) {
            result[depth] = A[i];
            back(i, depth + 1);
        }
    }
}