import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        
        int N = Integer.parseInt(br.readLine());
        while(N --> 0) {
            int x = Integer.parseInt(br.readLine());
            
            if(x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(x);
            }
        }
        
        System.out.println(sb);
    }
}