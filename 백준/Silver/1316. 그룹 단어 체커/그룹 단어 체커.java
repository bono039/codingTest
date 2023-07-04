import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        while(N --> 0) {
            Set<Character> set = new HashSet<>();
            boolean isContinue = true;
            
            char[] ch = br.readLine().toCharArray();
            set.add(ch[0]);
            
            for(int i = 1 ; i < ch.length ; i++) {
                if(set.contains(ch[i]) && ch[i - 1] != ch[i]) {
                    isContinue = false;
                }
                else {
                    set.add(ch[i]);
                }
            }
            
            if(isContinue)  cnt++;
        }
        
        System.out.println(cnt);
    }
}
