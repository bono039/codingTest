import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int len =  prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < len ; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();    // 답을 구했으므로 스택에서 제거
            }
            stack.push(i);
        }
        
        // 값을 구하지 못한 idx = 끝까지 가격이 떨어지지 않은 주식
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
        return answer;
    }
}