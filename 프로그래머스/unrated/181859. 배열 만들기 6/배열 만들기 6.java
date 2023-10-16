import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
       
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        while(i < arr.length) {     
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                i++;
            }
            else {
                if(stack.peek() == arr[i]) {
                    stack.pop();
                    i++;
                }
                else {
                    stack.push(arr[i]);
                    i++;
                }
            }
        }
        
        if(stack.isEmpty()) return new int[]{-1};
        
        int[] answer = new int[stack.size()];
        for(int k = stack.size() - 1 ; k >= 0 ; k--) {
            answer[k] = stack.pop();
        }
        
        return answer;
    }
}