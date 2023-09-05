import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < N ; i++) {
            char[] arr = br.readLine().toCharArray();
            if(solve(arr))  cnt++;
        }
        
        System.out.println(cnt);
    }
    
    private static boolean solve(char[] ch) {
        Stack<Character> stack = new Stack<>();
        
        for(int j = 0 ; j < ch.length ; j++) {
            if(stack.isEmpty()) {
                stack.push(ch[j]);
            }
            else {
                if(stack.peek() == ch[j]) {
                    stack.pop();
                }
                else {
                    stack.push(ch[j]);
                }
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}