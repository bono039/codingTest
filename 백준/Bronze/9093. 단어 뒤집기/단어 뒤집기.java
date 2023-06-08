import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            while(st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                answer.append(sb.reverse()).append(" ");
            }
            answer.append("\n");
            
        }
        System.out.println(answer);
    }
}