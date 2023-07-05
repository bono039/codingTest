import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        
        for(int i = 1 ; i <= N ; i++) {
            if(i < 100) {
                cnt++;
            }
            else {
                char[] ch = Integer.toString(i).toCharArray();
                boolean isEqual = true;
                
                for(int j = 1 ; j < ch.length - 1 ; j++) {
                    if((ch[1] - ch[0]) != (ch[j + 1] - ch[j])) {
                        isEqual = false;
                        break;
                    }
                }
                
                if(isEqual) cnt++;               
            }
        }
        
        System.out.println(cnt);
    }
}
