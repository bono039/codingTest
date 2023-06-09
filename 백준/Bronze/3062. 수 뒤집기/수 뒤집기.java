import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        String[][] arr = new String[T][2];
        int[] sum = new int[T];
        
        for(int i = 0 ; i < T ; i++) {
            arr[i][0] = br.readLine();
            
            StringBuilder sb = new StringBuilder(arr[i][0]);
            arr[i][1] = sb.reverse().toString();
            
            sum[i] = Integer.parseInt(arr[i][0]) + Integer.parseInt(arr[i][1]);
            answer.append(isPalindrome(sum[i]) ? "YES" : "NO").append("\n");
        }
        
        System.out.println(answer.toString());
    }
    
    private static boolean isPalindrome(int n) {
        char[] ch = Integer.toString(n).toCharArray();
        
        for(int i = 0 ; i < ch.length / 2 ; i++) {
            if(ch[i] != ch[ch.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}