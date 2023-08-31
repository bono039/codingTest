import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] alphabet = new int[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < str.length() ; j++) {
                alphabet[str.charAt(j) - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }
        Arrays.sort(alphabet);
        
        int num = 9;
        int turn = 25;
        int ans = 0;
        
        while(alphabet[turn] != 0) {
            ans += alphabet[turn] * num;
            turn--;
            num--;
        }
        
        System.out.println(ans);
    }
}