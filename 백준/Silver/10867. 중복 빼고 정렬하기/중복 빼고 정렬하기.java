import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(pq.contains(num)) {
                continue;
            }
            else {
                pq.add(num);
            }
        }
        
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}