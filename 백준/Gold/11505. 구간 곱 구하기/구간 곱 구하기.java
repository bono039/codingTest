import java.util.*;
import java.io.*;

public class Main {
    static int MOD = 1000000007;
    public static long[] arr, tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        arr = new long[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        // 트리 초기화
        tree = new long[N * 4];
        init(1, N, 1);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if(a == 1) {
                arr[b] = c;
                update(1, N, 1, b, c);
            }
            else if(a == 2) {
                sb.append(multiple(1, N, 1, b, (int) c) + "\n");
            }
        }
        
        System.out.println(sb);
        br.close();
    }
    
    // 각 구간별 구간 곱 저장
    public static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        
        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }
    
    // left ~ right 범위 내의 구간 곱 찾음
    public static long multiple(int start, int end, int node, int left, int right) {
        if(right < start || end < left)     return 1;            // 범위 밖에 있는 경우
        if(left <= start && end <= right)   return tree[node];   // 범위 안에 있는 경우
        
        int mid = (start + end) / 2;
        return (multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }
    
    // 수정 메소드 (idx : 구간 곱 수정하고자 하는 노드 / val : 수정할 값)
    public static long update(int start, int end, int node, int idx, long val) {
        if(idx < start || end < idx)    return tree[node];        // 범위 밖에 있으면 tree 값 수정하지 않고 바로 리턴
        if(start == end)                return tree[node] = val;  // 범위 안에 있으면 리프 노드 업데이트
        
        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end,node * 2 + 1, idx, val)) % MOD;
    }
}