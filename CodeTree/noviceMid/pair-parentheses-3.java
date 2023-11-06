import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] ch = br.readLine().toCharArray();

        int cnt = 0;
        for(int i = 0 ; i < ch.length - 1 ; i++) {
            for(int j = i + 1 ; j < ch.length ; j++) {
                if(ch[i] == '(' && ch[j] == ')') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
