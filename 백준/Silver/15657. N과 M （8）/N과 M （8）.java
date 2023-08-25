import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        ans = new int[M];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        back(0, 0);
        System.out.println(sb);
    }
    
    private static void back(int startIdx, int cnt) {
        if(cnt == M) {
            for(int i : ans)    sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = startIdx ; i < N ; i++) {
            ans[cnt] = arr[i];
            back(i, cnt + 1);
        }
    }
}