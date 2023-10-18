import java.util.*;

class Solution {    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 소인수분해
        for(int i = yellow ; i >= 1 ; i--) {
            if(yellow % i == 0) {                
                int sum = (i + yellow / i) *2 + 4;
                if(sum <= brown) {
                    answer[0] = Math.max(i + 2, yellow/i + 2);
                    answer[1] = Math.min(i + 2, yellow/i + 2);
                }
            }
        }
        
        return answer;
    }
}