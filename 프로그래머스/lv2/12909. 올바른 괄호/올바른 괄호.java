import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<String>();
        for(int i=0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') {
                stack.push("(");
            } else {
                // 스택이 비어있는 경우
                if(stack.empty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(!stack.empty()) {
            answer = false;
        }

        return answer;
    }
}