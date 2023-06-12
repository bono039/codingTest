import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> deque = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        while(N --> 0) {
            String[] str = br.readLine().split(" ");
            String order = str[0];
            
            switch(order) {
                case "push_front" :
                    deque.addFirst(Integer.parseInt(str[1]));
                    break;
                    
                case "push_back" :
                    deque.addLast(Integer.parseInt(str[1]));
                    break;
                    
                case "pop_front" :
                    if(deque.size() == 0) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                    
                case "pop_back" :
                    if(deque.size() == 0) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                    
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                    
                case "empty":
                    sb.append(deque.size() == 0 ? 1 : 0).append("\n");
                    break;
                    
                case "front" :
                    if(deque.size() == 0) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                    
                case "back" :
                    if(deque.size() == 0) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;                     
            }
        }
        
        System.out.println(sb);
    }
}