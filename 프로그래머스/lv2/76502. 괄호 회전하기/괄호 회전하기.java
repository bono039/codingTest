import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        
        for(int i = 0 ; i < s.length() ; i++) {
            String newStr = s.substring(i, s.length()) + s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            
            for(int j = 0 ; j < newStr.length() ; j++) {
                char ch = newStr.charAt(j);
                
                if(stack.isEmpty()) {
                    stack.push(ch);
                }
                else if(ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if(ch == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if(ch == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }  
            }
            
            if(stack.isEmpty())
                cnt++;
        }
        
        return cnt;
    }
}