import java.util.*;

class Solution {
    public int solution(int n) {
        
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        
        while(n > 0) {
            s.push(n % 3); 
            n /= 3;       
        }
        
        int pow = 1;
        while(s.size() > 0) {
            answer += s.pop() * pow;
            pow *= 3;
        }
        
        return answer;
    }
}