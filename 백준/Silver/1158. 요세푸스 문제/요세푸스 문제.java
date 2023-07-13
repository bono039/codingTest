import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) {
            queue.add(i);
        }
        
        sb.append("<");
        
        // K-1까지 처음에 있던 값을 맨 뒤로 보냄
        while(queue.size() != 1) {
            for(int i = 0 ; i < K - 1 ; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
