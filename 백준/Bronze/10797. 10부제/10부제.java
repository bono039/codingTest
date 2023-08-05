import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= 5 ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == target) cnt++;
        }
        System.out.println(cnt);
    }
}