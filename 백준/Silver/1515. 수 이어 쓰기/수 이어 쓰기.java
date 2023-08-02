import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine(); // 지우고 남은 수를 한 줄로 이어붙인 수
        
        int pt = 0;
        int base = 0;
        
        while(base++ <= 30000) {
            String tmp = Integer.toString(base);
            
            for(int i = 0 ; i < tmp.length() ; i++) {
                if(tmp.charAt(i) == str.charAt(pt)) {
                    pt++;
                }
                
                if(pt == str.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}