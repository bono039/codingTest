import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n ; i++) {
            char[] ch = br.readLine().toCharArray();
            int cnt = 0;
            int sum = 0;
            
            for(int j = 0 ; j < ch.length ; j++) {
                if(ch[j] == 'O') {
                    cnt++;
                    sum += cnt;
                } else {
                    cnt = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}